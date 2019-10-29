package com.nepous.provider.config;

import com.nepous.core.aspect.LogAspect;
import com.nepous.core.config.SwaggerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SwaggerConfiguration.class, LogAspect.class})
public class UacWebConfig {
}
