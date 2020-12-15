package com.letv.spring.controller;

import com.letv.spring.Response;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/test2")
    public Object sayHello2(){
        return "boot热部署";
    }
}
