package com.ttl.contoller;

import com.ttl.service.TtlBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bowen.yan
 * @since 2020-04-28
 */
@RequestMapping("/")
@RestController
public class TtlBizController {
    @Autowired
    private TtlBizService ttlBizService;

    // 主线程赋值，子线程获取值，同时logback.xml中 %X{userFlagKey}也可以获取值
    @RequestMapping("logback")
    public String testLogback() {
        return ttlBizService.testLogback();
    }
}
