package com.letv.sentinel.controller;

import com.letv.sentinel.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSentinel {

    @Autowired
    SentinelService sentinelService;

    @RequestMapping("hello")
    public String SayHello(){
        return sentinelService.lazySay("hello");
    }
}
