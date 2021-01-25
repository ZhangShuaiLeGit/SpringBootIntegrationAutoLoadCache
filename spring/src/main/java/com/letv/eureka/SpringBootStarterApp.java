package com.letv.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableZuulProxy
@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootStarterApp {

    /**
     * client1 BeanFactory /api/server @EnableEurekaServer
     * client2 BeanFactory /api @EnableEurekaServer
     * register1 BeanFactory /api/client
     * register2 BeanFactory /api/server
     * zuul BeanFactory @EnableZuulProxy
     */

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApp.class, args);
    }
}
