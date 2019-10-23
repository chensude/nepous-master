package com.nepous.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nepous-zipkin")
public interface TestFeignClient {

    @GetMapping("/zipkin/hello")
    String get();
}
