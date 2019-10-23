package com.nepous.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${server.servlet.context-path}")
    private String contentPath;
    @GetMapping("hello")
    public String get() {
        return "hello"+contentPath;
    }
}
