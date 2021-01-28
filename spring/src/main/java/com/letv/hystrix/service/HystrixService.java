package com.letv.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMethod4", commandKey = "getUserCache")
//    @HystrixCommand(fallbackMethod = "fallbackMethod4", commandKey = "getUserCache", commandProperties = {
//            @HystrixProperty(name="requestCache.enabled", value = "true")})
    @CacheResult(cacheKeyMethod = "getCacheKey1")
    public Object getCacheService(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("傻了吧，没走缓存吧");
        return restTemplate.getForEntity("http://EUREKA-SERVER1/hello", String.class).getBody();
    }


    @HystrixCommand
    @CacheRemove(commandKey = "getUserCache", cacheKeyMethod = "getCacheKey1")
    public void removeCacheService(Long id) {
        System.out.println("removeCache id:" + id);
    }

    /**
     * 为缓存生成key的方法
     * 重写getCacheKey方法，底层通过动态代理(cglib)实现
     * 不要有业务逻辑，会被调用俩次
     * JDK动态代理只能对实现了接口的类生成代理，而不能针对类
     * CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法（继承）
     */
    public String getCacheKey1(Long id) {
        System.out.println("我为啥没被调用");
        return String.valueOf(id);
    }

    public String fallbackMethod4(Long id) {
        return "彻底歇菜了吧" + id;
    }
}
