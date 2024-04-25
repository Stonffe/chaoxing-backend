package com.example.exam.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        log.info("跨域服务启动");
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .maxAge(3600);
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("跨域服务启动");
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 或者 .allowedOrigins("https://example.com")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**") // 这里配置了静态资源的URL映射路径
                .addResourceLocations("file:D:/img/"); // 这里指定了静态资源的存放位置
    }
}