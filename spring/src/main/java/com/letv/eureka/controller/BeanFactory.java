package com.letv.eureka.controller;

import com.letv.eureka.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/server")
public class BeanFactory {

    @RequestMapping("/test")
    public Response sayHello(){
        Response<String> response = new Response<>();
        response.setData("hello,boot");
        return response;
    }

    @RequestMapping("/test1")
    public Object sayHello1(){
        System.out.println("热部署2");
        return "hello,boot";
    }

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Index() {
        List<String> services = client.getServices();
        log.info("/hello, host:{}, serverId:{}", services.get(0), services.get(0));
        return "我是" + System.getProperty("spring.profiles.active");
    }
}
