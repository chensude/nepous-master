package com.nepous.security.feign;

import com.nepous.security.GlobalConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value="nepous-provider-uac",configuration = OAuth2FeignAutoConfiguration .class,fallback = TestFallBack.class)
public interface TestClient {

    @PostMapping("/uac/role/queryList")
    String getHello();

}
