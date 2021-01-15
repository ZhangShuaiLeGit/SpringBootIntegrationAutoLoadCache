package com.letv.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarterApp {

    /**
     * sentinel测试博客：https://blog.csdn.net/yuanchangliang/article/details/111663821
     * resource：资源名，即限流规则的作用对象
     * limitApp：流控针对的调用来源，若为 default 则不区分调用来源
     * grade：限流阈值类型（QPS 或并发线程数）；0代表根据并发数量来限流，1代表根据QPS来进行流量控制
     * count：限流阈值
     * strategy：调用关系限流策略
     * controlBehavior：流量控制效果（直接拒绝、Warm Up、匀速排队）
     * clusterMode：是否为集群模式
     */


    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApp.class, args);
    }
}
