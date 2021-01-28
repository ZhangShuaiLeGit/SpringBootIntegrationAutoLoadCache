package com.letv.sentinel.service;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import org.springframework.stereotype.Service;

@Service
public class SentinelService {
    private static int count = 1;

    /**
     * exceptionsToTrace = Throwable.class 一般用不到
     * exceptionsToIgnore = Throwable.class
     */
    @SentinelResource(value = "doSomeThing", entryType = EntryType.IN,
            blockHandler = "blockHandler", fallback = "fallbackHandler", exceptionsToTrace = RuntimeException.class)
    public String lazySay(String some) {
        DegradeRule degradeRule = new DegradeRule();
        System.out.println(degradeRule.toString());
        if (count % 3 == 0) {
            try {
                throw new RuntimeException("歇歇吧");
            } finally {
                count++;
            }
        }
        count++;
        return some;
    }

    // 限流与阻塞处理
    public String blockHandler(String some, BlockException ex) {
        return  "blockHandler：" + some + ex;
    }

    // 熔断处理
    public String fallbackHandler(String str) {
        return "fallbackHandler：" + str;
    }
}
