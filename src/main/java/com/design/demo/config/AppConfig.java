package com.design.demo.config;

import com.design.demo.domain.Student;
import com.design.demo.web.Test;
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
