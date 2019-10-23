package com.nepous.zipkin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("zpkin/hello")
    public String get(){
        return "zpKin-hello";
    }
}
