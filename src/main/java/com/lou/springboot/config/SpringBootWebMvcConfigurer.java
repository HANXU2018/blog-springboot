package com.lou.springboot.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringBootWebMvcConfigurer implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //file:///C:/Users/hx/Desktop/tomcatstudy/1.png
        registry.addResourceHandler("/files/**").addResourceLocations("file:C:/Users/hx/Desktop/tomcatstudy/");
    }
}
