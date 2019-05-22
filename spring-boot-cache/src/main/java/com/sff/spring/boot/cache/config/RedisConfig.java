package com.sff.spring.boot.cache.config;


import com.sff.spring.boot.cache.domain.Emp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Emp> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<String, Emp> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Emp> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Emp.class);
        //设置key的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化方式
        template.setValueSerializer(jsonRedisSerializer);
        return template;
    }


   // @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("demo-task");
        taskScheduler.setThreadGroupName("aa");
        return taskScheduler;
    }
}
