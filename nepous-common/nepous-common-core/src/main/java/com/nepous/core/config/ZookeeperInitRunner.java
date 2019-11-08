package com.nepous.core.config;

import com.nepous.core.generator.UniqueIdGenerator;
import com.nepous.properties.NepousProperties;
import com.nepous.core.RegistryCenterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@Slf4j
@Order
public class ZookeeperInitRunner implements CommandLineRunner {

    @Autowired
    private NepousProperties nepousProperties;
    @Value("${spring.application.name}")
    private String applicationName;


    @Override
    public void run(String... args) throws Exception {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info("###ZookeeperInitRunner，init. HostAddress={}, applicationName={}", hostAddress, applicationName);
        RegistryCenterFactory.startup(nepousProperties, hostAddress, applicationName);
        log.info("###ZookeeperInitRunner，finish<<<<<<<<<<<<<");
    }
}
