package com.nepous.security.config;

import com.nepous.core.config.MybatisPlusConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import({MybatisPlusConfig.class})
public class MpPageConfig {
}
