package com.design.demo.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:测试根据resource里的文件配置化注入bean
 * @PropertySource指定配置文件地址
 * @ConfigurationProperties指定bean注入属性的前缀
 * @Author: yedong
 * @Date: 2019/10/7 21:42
 * @Modified by:
 */
@Component
@ConfigurationProperties(prefix = "yedong")
@PropertySource("classpath:yedong.properties")
@Data
public class yedong {
    String name;
    String age;

}
