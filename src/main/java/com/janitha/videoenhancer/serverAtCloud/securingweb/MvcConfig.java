package com.janitha.videoenhancer.serverAtCloud.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/Welcome").setViewName("Welcome");
        registry.addViewController("/").setViewName("Welcome");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/LogIn").setViewName("LogIn");
        registry.addViewController("/Register").setViewName("Register");
    }

}