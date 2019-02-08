package com.sff.spring.boot.mvc.config;

import com.sff.spring.boot.mvc.servlet.MyFilter;
import com.sff.spring.boot.mvc.servlet.MyListener;
import com.sff.spring.boot.mvc.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {



    /**
     * 利用 ServletListenerRegistrationBean 注册 listener
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean =
                new ServletListenerRegistrationBean(new MyListener());
        return listenerRegistrationBean;
    }


    /**
     * 利用 ServletRegistrationBean 注册自己的 servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new MyServlet(), "/hello/servlet");
        return servletRegistrationBean;
    }

    /**
     * 利用 FilterRegistrationBean 注册 filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //注册自己的 filter
        filterRegistrationBean.setFilter(new MyFilter());
        //注册拦截路径
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/hello/servlet"));
        return filterRegistrationBean;
    }

    //@Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8585);
        return factory;
    }


}
