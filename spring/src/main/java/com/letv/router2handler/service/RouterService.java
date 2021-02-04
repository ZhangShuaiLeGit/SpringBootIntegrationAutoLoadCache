package com.letv.router2handler.service;

import com.letv.router2handler.interceptor.StrategyHandler;
import org.springframework.stereotype.Service;

@Service
public class RouterService implements StrategyHandler<Long, String> {

    @Override
    public String apply(Long param) {
        return "1";
    }
}
