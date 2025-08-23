package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.LoggingFilter;

/**
 * Registers LoggingFilter into the servlet container so that
 * ApplicationFilterChain will include it.
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LoggingFilter());
        bean.setOrder(1); // run early
        bean.addUrlPatterns("/*");
        return bean;
    }
}