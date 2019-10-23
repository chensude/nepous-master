package com.nepous.gateway.controller;

import com.nepous.gateway.feign.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private TestFeignClient testFeignClient;
    @GetMapping("hello")
    public String get() {
        return testFeignClient.get();
    }
}
