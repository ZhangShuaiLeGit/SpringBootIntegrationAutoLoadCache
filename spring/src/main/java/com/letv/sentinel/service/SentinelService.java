package com.letv.sentinel.service;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SentinelService {
    static int count = 1;

    @SentinelResource(value = "doSomeThing", entryType = EntryType.IN,
            blockHandler = "exceptionHandler", fallback = "fallbackHandler", exceptionsToTrace = TimeoutException.class)
    public String lazySay(String some) {
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
    public String exceptionHandler(String some, BlockException ex) throws Exception {
        try {
            throw new TimeoutException(ex.getMessage());
        } finally {
            System.out.println(ex.getMessage());
        }
    }

    // 熔断处理
    public String fallbackHandler(String str) {
        return "fallbackHandler：" + str;
    }
}
