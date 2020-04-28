package com.ttl.util.ttl;

/**
 * <p>ThreadLocalUtil</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/5/27 14:41
 * @company :
 */

public class ThreadLocalUtil {
    public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    //获取线程中保存的值
    public static ThreadLocal getThreadLocal() {
        return THREAD_LOCAL;
    }
}
