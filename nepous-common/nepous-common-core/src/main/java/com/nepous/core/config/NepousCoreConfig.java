package com.nepous.core.config;

import com.nepous.core.config.properties.NepousProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NepousProperties.class)
public class NepousCoreConfig {
}
