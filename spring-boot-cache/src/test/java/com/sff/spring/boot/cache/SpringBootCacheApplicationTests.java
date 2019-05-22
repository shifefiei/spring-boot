package com.sff.spring.boot.cache;

import com.alibaba.fastjson.JSON;
import com.sff.spring.boot.cache.domain.Dept;
import com.sff.spring.boot.cache.domain.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    private JavaMailSenderImpl sender;
    /**
     * 发送简单邮件
     */
    @Test
    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通知");
        mailMessage.setText("今晚7:00开会");
        mailMessage.setTo("aaa@163.com");
        mailMessage.setFrom("bbb@qq.com");
        sender.send(mailMessage);
    }

    /**
     * 发送复杂邮件
     *
     * @throws Exception
     */
    @Test
    public void sendMail2() throws Exception {

        MimeMessage mimeMessage = sender.createMimeMessage();
        //创建多文件邮件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setSubject("通知");
        messageHelper.setText("<b style='color:red;'>今晚7:00开会</b>", true);
        messageHelper.setTo("aaa@163.com");
        messageHelper.setFrom("bbb@qq.com");
        //添加附件
        messageHelper.addAttachment("nfc.png", new File("/Users/shifeifei/Desktop/nfc.png"));
        sender.send(mimeMessage);
    }


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
