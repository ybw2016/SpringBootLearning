package com.ttl.service;

/**
 * <p>TtlThreadPoolService</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:45
 * @company :
 */

public interface TtlThreadPoolService {
    // 同步获取，能获取值
    String testThreadLocal();

    // 异步获取，不能获取值
    String testThreadLocalAsync();

    // 异步获取，通过InheritThreadLocal能获取值值
    String testInheritThreadLocalAsync();

    // 异步线程池，通过InheritThreadLocal不能获取值（超过核心线程数之外的不能获取）
    String testInheritThreadLocalThreadPool();

    // 异步线程池，通过TransmitThreadLocal能获取值
    String testTransmitThreadLocalThreadPool();
}
