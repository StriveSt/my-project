package com.plt.base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxq
 */
@Configuration
public class ControllerAdviceAutoConfiguration {
    @Bean
    public GlobalExceptionAdvice getGlobalExceptionAdvice() {
        return new GlobalExceptionAdvice();
    }
}
