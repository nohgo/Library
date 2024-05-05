package com.github.nohgo.config;

import com.github.nohgo.interceptors.AdminInterceptor;
import com.github.nohgo.interceptors.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).excludePathPatterns("/register");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
    }
}
