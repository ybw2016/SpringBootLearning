package com.ttl.contoller;

import com.ttl.constant.TtlTitle;
import com.ttl.service.TtlDemoService;
import com.ttl.util.LogUtil;
import com.ttl.util.ttl.InheritableThreadLocalUtil;
import com.ttl.util.ttl.ThreadLocalUtil;
import com.ttl.util.ttl.TransmittableThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>PiceaContoller</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:40
 * @company :
 */
@RequestMapping("/")
@RestController
public class TtlDemoController {
    @Autowired
    private TtlDemoService ttlDemoService;

    @RequestMapping("thread-local")
    public String testThreadLocal() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlTitle.testThreadLocal.getValue());
        LogUtil.log(TtlTitle.testThreadLocal, Thread.currentThread(), threadLocal.get());

        return ttlDemoService.testThreadLocal();
    }

    @RequestMapping("thread-local/async")
    public String testThreadLocalAsync() {
        ThreadLocal threadLocal = ThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlTitle.testThreadLocalAsync.getValue());
        LogUtil.log(TtlTitle.testThreadLocalAsync, Thread.currentThread(), threadLocal.get());

        return ttlDemoService.testThreadLocalAsync();
    }

    @RequestMapping("inherit-thread-local/async")
    public String testInheritThreadLocalAsync() {
        ThreadLocal threadLocal = InheritableThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlTitle.testInheritThreadLocalAsync.getValue());
        LogUtil.log(TtlTitle.testInheritThreadLocalAsync, Thread.currentThread(), threadLocal.get());

        return ttlDemoService.testInheritThreadLocalAsync();
    }

    @RequestMapping("inherit-thread-local/thread-pool")
    public String testInheritThreadLocalThreadPool() {
        ThreadLocal threadLocal = InheritableThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlTitle.testInheritThreadLocalThreadPool.getValue());
        LogUtil.log(TtlTitle.testInheritThreadLocalThreadPool, Thread.currentThread(), threadLocal.get());

        return ttlDemoService.testInheritThreadLocalThreadPool();
    }

    @RequestMapping("transmit-thread-local/thread-pool")
    public String testTransmitThreadLocalThreadPool() {
        ThreadLocal threadLocal = TransmittableThreadLocalUtil.getThreadLocal();
        threadLocal.set(TtlTitle.testTransmitThreadLocalThreadPool.getValue());
        LogUtil.log(TtlTitle.testTransmitThreadLocalThreadPool, Thread.currentThread(), threadLocal.get());

        return ttlDemoService.testTransmitThreadLocalThreadPool();
    }
}
