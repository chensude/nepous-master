package com.nepous.zipkin.controller;

import org.bouncycastle.util.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/zipkin/hello")
    public String get(){
        return "zpKin-hello";
    }
}
