package com.ttl.service.impl;

import com.ttl.constant.TtlMiscTitle;
import com.ttl.service.TtlBizService;
import com.ttl.util.LogUtil;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
public class TtlBizServiceImpl implements TtlBizService {
    @Override
    public String testLogback() {
        TtlMiscTitle title = TtlMiscTitle.testLogback;
        String userKey = "userFlagKey";
        MDC.put(userKey, "TRANSMITTABLE-THREAD-LOCAL-USER");

        Thread thread = new Thread(() -> {
            LogUtil.log(title, Thread.currentThread(), MDC.get(userKey));
            System.out.println();
            MDC.remove(userKey);
        });
        thread.start();

        return title.toString();
    }
}
