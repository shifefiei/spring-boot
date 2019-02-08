package com.sff.spring.boot.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@Configuration
public class MyViewConfig {

    @Bean
    public ViewResolver myView() {
        return new MyViewResolver();
    }

    /**
     * 自定义视图
     */
    private class MyViewResolver implements ViewResolver {

        @Nullable
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            System.out.println("----------------> my view resolver");
            return null;
        }
    }
}
