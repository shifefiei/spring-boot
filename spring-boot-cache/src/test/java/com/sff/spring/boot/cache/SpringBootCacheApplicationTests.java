package com.sff.spring.boot.cache;

import com.sff.spring.boot.cache.domain.Dept;
import com.sff.spring.boot.cache.domain.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetRedis() {

        Emp emp = new Emp();
        emp.setId(4L);
        emp.setName("kate");
        emp.setDeptId(1L);
        emp.setEmail("SAJJee@qq.com");
        emp.setSex(0);
        redisTemplate.opsForValue().set("emp:4", emp);
    }


    @Test
    public void testSetRedisDept() {

        Dept d = new Dept();
        d.setDeptName("中国人");
        d.setId(2l);

        redisTemplate.opsForValue().set("dept:1", d);
    }


    @Test
    public void testQueryRedis() {
        System.out.println(redisTemplate.opsForValue().get("emp:2"));
    }

    @Test
    public void testDeleteRedis() {
        redisTemplate.delete("emp:4");
    }


}
