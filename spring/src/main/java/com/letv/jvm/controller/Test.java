package com.letv.jvm.controller;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.weaving.AspectJWeavingEnabler;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * logback.xml加载早于application.properties，所以如果你在logback.xml使用了变量时，
 * 而这个变量是写在application.properties时，那么就会获取不到，只要改成logback-spring.xml就可以解决。
 */

public class Test extends AspectJWeavingEnabler {
    public static void main(String[] args) {
//        LiftState
    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        String tid = String.valueOf(Thread.currentThread().getId());
        System.out.printf("Thread#%s : in call\n", tid);
        return tid;
    }
    public static void main(String[] args) throws Exception {
        List<Future<String>> results = new ArrayList<>();
        /**
         * https://www.cnblogs.com/jfaith/p/11114470.html
         * newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
         * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
         */
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<100;i++)
            results.add(es.submit(new Task()));
        es.shutdown();
//        ThreadLocal
        for(Future<String> res : results)
            System.out.println(res.get());
    }
}