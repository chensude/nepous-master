package com.nepous.security.feign;

import org.springframework.stereotype.Component;

@Component
public class TestFallBack implements TestClient{
    @Override
    public String getHello() {
        return null;
    }
}
