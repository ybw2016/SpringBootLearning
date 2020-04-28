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

    @RequestMapping("logback")
    public String testLogback() {
        return ttlBizService.testLogback();
    }
}
