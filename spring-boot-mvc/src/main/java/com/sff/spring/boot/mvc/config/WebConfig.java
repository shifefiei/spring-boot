package com.sff.spring.boot.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * "classpath:/META-INF/resources/", "classpath:/resources/",
     "classpath:/static/", "classpath:/public/"
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static11/**")
                .addResourceLocations("classpath:/static/")
        ;
    }
}
