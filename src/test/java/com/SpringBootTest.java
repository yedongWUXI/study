package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
/**
 * @author yeodng
 */
public class SpringBootTest {

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean
    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest.class, args);
    }

    /**
     * 简单测试发送邮件
     *
     * @throws Exception
     */
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo("1280125483@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("春节去哪玩呀");
        mailSender.send(message);
    }


}
