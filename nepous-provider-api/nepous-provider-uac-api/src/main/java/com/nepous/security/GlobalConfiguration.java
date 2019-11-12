package com.nepous.security;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class GlobalConfiguration {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
