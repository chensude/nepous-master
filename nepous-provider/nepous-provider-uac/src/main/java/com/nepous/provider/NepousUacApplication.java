package com.nepous.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.nepous.provider.mapper")
public class NepousUacApplication {

    public static void main(String[] args) {
        SpringApplication.run(NepousUacApplication.class,args);
    }
}
