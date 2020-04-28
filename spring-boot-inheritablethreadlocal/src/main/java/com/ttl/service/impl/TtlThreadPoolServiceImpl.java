package com.ttl.service.impl;

import com.ttl.constant.TtlTitle;
import com.ttl.service.TtlThreadPoolService;
import com.ttl.util.LogUtil;
import com.ttl.util.ttl.InheritableThreadLocalUtil;
import com.ttl.util.ttl.ThreadLocalUtil;
import com.ttl.util.ttl.TransmittableThreadLocalUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>TtlDemoServiceImpl</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:45
 * @company :
 */

@Service
public class TtlThreadPoolServiceImpl implements TtlThreadPoolService {
    @Override
    public String testThreadLocal() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        LogUtil.log(TtlTitle.testThreadLocal, Thread.currentThread(), threadLocal.get());
        threadLocal.remove();
        System.out.println();

        return TtlTitle.testThreadLocal.toString();
    }

    @Override
    public String testThreadLocalAsync() {
        Thread thread = new Thread(() -> {
            ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
            LogUtil.log(TtlTitle.testThreadLocalAsync, Thread.currentThread(), threadLocal.get());
            threadLocal.remove();
            System.out.println();
        });
        thread.start();

        return TtlTitle.testThreadLocalAsync.toString();
    }

    @Override
    public String testInheritThreadLocalAsync() {
        new Thread(() -> {
            ThreadLocal threadLocal = InheritableThreadLocalUtil.getThreadLocal();
            LogUtil.log(TtlTitle.testInheritThreadLocalAsync, Thread.currentThread(), threadLocal.get());
            threadLocal.remove();
            System.out.println();
        }).run();

        return TtlTitle.testInheritThreadLocalAsync.toString();
    }

    @Async("taskExecutor")
    @Override
    public String testInheritThreadLocalThreadPool() {
        ThreadLocal threadLocal = InheritableThreadLocalUtil.getThreadLocal();
        LogUtil.log(TtlTitle.testInheritThreadLocalThreadPool, Thread.currentThread(), threadLocal.get());
        threadLocal.remove();
        System.out.println();

        return TtlTitle.testInheritThreadLocalThreadPool.toString();
    }

    @Async("taskExecutorTtl")
    @Override
    public String testTransmitThreadLocalThreadPool() {
        ThreadLocal threadLocal = TransmittableThreadLocalUtil.getThreadLocal();
        LogUtil.log(TtlTitle.testTransmitThreadLocalThreadPool, Thread.currentThread(), threadLocal.get());
        threadLocal.remove();
        System.out.println();

        return TtlTitle.testTransmitThreadLocalThreadPool.toString();
    }
}
