package com.letv.router2handler.controller;

import com.letv.router2handler.interceptor.AbstractStrategyRouter;
import com.letv.router2handler.interceptor.StrategyHandler;
import com.letv.router2handler.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RouterController extends AbstractStrategyRouter<Long, String> {

    @Autowired
    private RouterService routerService;

    @RequestMapping("/router/{id}")
    public Object saySomeThing(@PathVariable Long id){
        return applyStrategy(id);
    }

    @Override
    protected StrategyMapper<Long, String> registerStrategyMapper() {
        return new StrategyMapper<Long, String>(){
            @Override
            public StrategyHandler<Long, String> get(Long param) {
                return routerService;
            }
        };
    }
}
