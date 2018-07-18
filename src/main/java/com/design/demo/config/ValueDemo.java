package com.design.demo.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 测试@value ，只要在resources里的都可以获取到
 * 没必要在application.properties里
 * @Author: wxzhangyd
 * @Date: 2018/6/20 15:11
 * @Modified by:
 */
@Component
@Data
@NoArgsConstructor
public class ValueDemo {

    @Autowired
    ValueDemo valueDemo;

    @Value("${jdbc.driverClass}")
    private String driver;

    @PostConstruct
    public void run() {
        System.out.println(driver);
    }


    public ValueDemo(String s) {
        init(driver);
    }

    public String init(String s) {
        System.out.println(valueDemo.driver);
        return "yedong";
    }
    public void getValue(String s) {
        System.out.println(driver);
    }


}

