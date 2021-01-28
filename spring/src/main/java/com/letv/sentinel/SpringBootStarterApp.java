package com.letv.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarterApp {

    /**
     * sentinel测试博客：https://blog.csdn.net/yuanchangliang/article/details/111663821
     * resource：资源名，即限流规则的作用对象 底层通用
     * limitApp：流控针对的调用来源，若为 default 则不区分调用来源 底层通用
     * grade：限流阈值类型（QPS 或并发线程数）；0代表根据并发数量来限流，1代表根据QPS来进行流量控制
     * count：限流阈值
     * strategy：调用关系限流策略
     * controlBehavior：流量控制效果（直接拒绝、Warm Up、匀速排队）
     * maxQueueingTimeMs：当controlBehavior=2时，排队等待时间
     * clusterMode：是否为集群模式
     * 降级
     * grade: 降级策略（0:平均RT，1:异常比率）
     * timeWindow: 降级发生时的降级恢复超时（秒)
     * count: RT阈值或异常率阈值计数
     * 系统
     * highestSystemLoad: 负值表示没有阈值检查。
     * highestCpuUsage: cpu使用率，介于[0，1]之间
     * qps:
     * avgRt:
     * maxThread:
     * 授权
     * strategy: 模式：0表示白名单；1表示黑名单。
     * 热点
     * grade：限流阈值类型0：线程数（客户端并发控制）1：QPS（默认）
     * paramIdx：参数索引
     * count：单机阈值
     * paramFlowItemList：额外选项，针对特定的参数单独限流
     * clusterMode：是否为集群模式
     * clusterConfig：集群阈值模式
     */


    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApp.class, args);
    }
}
