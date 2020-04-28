package com.ttl.contoller;

import com.ttl.constant.TtlMiscTitle;
import com.ttl.service.TtlRunnableCallableService;
import com.ttl.util.LogUtil;
import com.ttl.util.ttl.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bowen.yan
 * @since 2020-04-28
 */
@RequestMapping("/")
@RestController
public class TtlRunnableCallableController {
    @Autowired
    private TtlRunnableCallableService ttlRunnableCallableService;

    @RequestMapping("runnable")
    public String testRunnable() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlMiscTitle.testRunnable.getValue());
        LogUtil.log(TtlMiscTitle.testRunnable, Thread.currentThread(), threadLocal.get());

        return ttlRunnableCallableService.testRunnable();
    }

    @RequestMapping("runnable-ttl")
    public String testRunnableTtl() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlMiscTitle.testRunnableTtl.getValue());
        LogUtil.log(TtlMiscTitle.testRunnableTtl, Thread.currentThread(), threadLocal.get());

        return ttlRunnableCallableService.testRunnableTtl();
    }

    @RequestMapping("callable")
    public String testCallable() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlMiscTitle.testCallable.getValue());
        LogUtil.log(TtlMiscTitle.testCallable, Thread.currentThread(), threadLocal.get());

        return ttlRunnableCallableService.testCallable();
    }

    @RequestMapping("callable-ttl")
    public String testCallableTtl() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlMiscTitle.testCallableTtl.getValue());
        LogUtil.log(TtlMiscTitle.testCallableTtl, Thread.currentThread(), threadLocal.get());

        return ttlRunnableCallableService.testCallableTtl();
    }
}
