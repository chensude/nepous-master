package com.nepous.security.controller.rpc;

import com.nepous.security.feign.TestClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClient1 implements TestClient {

    //@LogAnnotation
  //  @ApiOperation("Test")
    @Override
    public String getHello() {
        return "TestClient1";
    }
}
