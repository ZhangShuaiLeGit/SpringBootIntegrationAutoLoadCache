package com.letv.spring.controller;

import com.letv.spring.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/hello, host:{}, serverId:{}", instance.getHost(), instance.getServiceId());
        return "hello client";
    }
}
