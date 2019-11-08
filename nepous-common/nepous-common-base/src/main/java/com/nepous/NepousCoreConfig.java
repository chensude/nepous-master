package com.nepous;

import com.nepous.properties.NepousProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NepousProperties.class)
public class NepousCoreConfig {
}
