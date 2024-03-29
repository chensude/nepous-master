package com.nepous.core.config;

import com.nepous.core.config.properties.NepousProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
public class AsyncTaskExecutorConfiguration implements AsyncConfigurer {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private NepousProperties nepousProperties;

    @Override
    @Bean(name="taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(nepousProperties.getTask().getCorePoolSize());
        executor.setMaxPoolSize(nepousProperties.getTask().getMaxPoolSize());
        executor.setQueueCapacity(nepousProperties.getTask().getQueueCapacity());
        executor.setKeepAliveSeconds(nepousProperties.getTask().getKeepAliveSeconds());
        executor.setThreadNamePrefix(nepousProperties.getTask().getThreadNamePrefix());
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
