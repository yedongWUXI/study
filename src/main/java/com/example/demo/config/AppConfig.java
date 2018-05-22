package com.example.demo.config;

import com.example.demo.domain.Student;
import com.example.demo.web.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhangyedong
 * @date
 */
@Configuration
public class AppConfig {

    @Bean(name = "student")
    public Student student(){
        Student student = new Student();
        student.setName("zs");

        return student;
    }

    @Bean
    public Test test(){
        return new Test();
    }

}
