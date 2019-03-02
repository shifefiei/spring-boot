package com.sff.spring.boot.cache.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@MapperScan(value = "com.sff.spring.boot.cache.dao")
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    //定制mybatis配置
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {

        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                //开启驼峰命令
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
