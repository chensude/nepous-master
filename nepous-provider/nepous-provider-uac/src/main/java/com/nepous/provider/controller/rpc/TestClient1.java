package com.nepous.provider.controller.rpc;

import com.nepous.core.annotation.LogAnnotation;
import com.nepous.provider.feign.TestClientApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClient1 implements TestClientApi {

    @LogAnnotation
    @ApiOperation("Test")
    @Override
    public String getHello() {
        return "TestClient1";
    }
}
