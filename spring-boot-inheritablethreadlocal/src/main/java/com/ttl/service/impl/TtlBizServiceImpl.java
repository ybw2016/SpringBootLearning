package com.ttl.service.impl;

import com.ttl.constant.KeyConstant;
import com.ttl.constant.TtlMiscTitle;
import com.ttl.service.TtlBizService;
import com.ttl.util.LogUtil;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TtlBizServiceImpl implements TtlBizService {
    @Override
    public String testLogback() {
        TtlMiscTitle title = TtlMiscTitle.testLogback;
        Thread thread = new Thread(() -> {
            LogUtil.log(title, Thread.currentThread(), MDC.get(KeyConstant.USER_SESSION_KEY));
            System.out.println();
            MDC.remove(KeyConstant.USER_SESSION_KEY);
        });
        thread.start();

        return title.toString();
    }

    @Async("taskExecutorTtl")
    @Override
    public String testLogbackThreadPool() {
        TtlMiscTitle title = TtlMiscTitle.testLogbackThreadPool;

        LogUtil.log(title, Thread.currentThread(), MDC.get(KeyConstant.USER_SESSION_KEY));
        System.out.println();
        MDC.remove(KeyConstant.USER_SESSION_KEY);

        return title.toString();
    }
}
