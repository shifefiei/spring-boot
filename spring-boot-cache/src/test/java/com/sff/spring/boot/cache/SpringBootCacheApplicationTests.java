package com.sff.spring.boot.cache;

import com.alibaba.fastjson.JSON;
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


    //注入自定义序列化方式模板
    @Autowired
    private RedisTemplate<String, Emp> empRedisTemplate;
    @Test
    public void testSetRedis() {

        Emp emp = new Emp();
        emp.setId(4L);
        emp.setName("阿江");
        emp.setDeptId(1L);
        emp.setEmail("SAJJee@qq.com");
        emp.setSex(0);
        empRedisTemplate.opsForValue().set("emp:4", emp);//操作字符串
    }





    @Test
    public void testSetRedisDept() {
        Dept d = new Dept();
        d.setDeptName("中国人");
        d.setId(2l);

        String s = JSON.toJSONString(d);
        redisTemplate.opsForValue().set("dept:1", s);
    }

    @Test
    public void testQueryRedis() {
        System.out.println(redisTemplate.opsForValue().get("dept:1"));
    }

    @Test
    public void testDeleteRedis() {
        redisTemplate.delete("dept:1");
    }


}
