package com.nepous.provider.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="nepous-provider-uac")
public interface TestClientApi {

    @GetMapping("/api/uac/hello")
    String getHello();

}
