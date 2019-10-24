package com.nepous.provider.controller.rpc;

import com.nepous.provider.feign.TestClientApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClient1 implements TestClientApi {
    @Override
    public String getHello() {
        return "TestClient1";
    }
}
