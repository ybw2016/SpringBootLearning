package com.ttl.util;

import com.ttl.constant.TtlTitle;

/**
 * @author bowen.yan
 * @since 2020-04-28
 */
public class LogUtil {
    public static void log(TtlTitle title, Thread thread, Object value) {
        System.out.println(String.format("%s ------- 当前线程：%s，ThreadLocal值：%s",
            title, thread.getName(), value));
    }
}
