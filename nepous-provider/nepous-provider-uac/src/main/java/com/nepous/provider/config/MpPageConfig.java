package com.nepous.provider.config;

import com.nepous.core.config.MybatisPlusConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MybatisPlusConfig.class)
public class MpPageConfig {
}
