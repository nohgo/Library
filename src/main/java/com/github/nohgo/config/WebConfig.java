package com.github.nohgo.config;

import com.github.nohgo.interceptors.AdminInterceptor;
import com.github.nohgo.interceptors.AuthInterceptor;
import com.github.nohgo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthService authService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(authService)).excludePathPatterns("/register");
        registry.addInterceptor(new AdminInterceptor(authService)).addPathPatterns("/admin/**");
    }
}
