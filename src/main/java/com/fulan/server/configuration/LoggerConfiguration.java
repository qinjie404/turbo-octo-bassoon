package com.fulan.server.configuration;

import com.fulan.server.dao.LoggerDao;
import com.fulan.server.interceptor.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 13862
 */
@Configuration
public class LoggerConfiguration implements WebMvcConfigurer {
    @Autowired
    private LoggerDao loggerDao;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor(loggerDao)).addPathPatterns("/**");
    }

}
