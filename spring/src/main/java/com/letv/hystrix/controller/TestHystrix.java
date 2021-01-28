package com.letv.hystrix.controller;

import com.letv.hystrix.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestHystrix {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixService hystrixService;

    private static final String localUrl = "localhost:";

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String HelloConsumer() {
        return restTemplate.getForEntity("http://EUREKA-SERVER/hello", String.class).getBody();
    }

    @GetMapping("/testFallback/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public Object testFallback(@PathVariable Long id) {
        return restTemplate.getForEntity("http://EUREKA-SERVER1/hello", String.class).getBody();
    }

    public String fallbackMethod1(Long id) {
        return "歇歇吧，没服务了" + id;
    }

    @GetMapping("/testException/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod2")
    public Object testException(@PathVariable Long id) {
        String url = localUrl + id + "/hello";
        return restTemplate.getForEntity("http://EUREKA-SERVER1/hello", String.class).getBody();
    }

    public String fallbackMethod2(Long id) {
        return "歇歇吧，报错了" + id;
    }

    @GetMapping("/testCommand/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod3", ignoreExceptions = {NullPointerException.class})
    public Object getUserCommand(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }

        return "厉害，避开所有错误";
    }

    public String fallbackMethod3(Long id) {
        return "歇歇吧，IndexOutOfBoundsException" + id;
    }

    @GetMapping("/testCache/{id}")
    public Object testCache(@PathVariable Long id) throws Exception {
        Object res = hystrixService.getCacheService(id);
        System.out.println(res);
        Thread.sleep(200);
        res = hystrixService.getCacheService(id);
        System.out.println(res);
        Thread.sleep(200);
        res = hystrixService.getCacheService(id);
        System.out.println(res);
        return res;
    }

    @GetMapping("/testRemoveCache/{id}")
    public Object testRemoveCache(@PathVariable Long id) {
        Object res = hystrixService.getCacheService(id);
        hystrixService.removeCacheService(id);
        res = hystrixService.getCacheService(id);
        return res;
    }
}

