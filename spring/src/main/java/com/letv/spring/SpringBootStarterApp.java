package com.letv.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootStarterApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApp.class, args);
    }
}
