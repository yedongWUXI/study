package com.design.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:全局配置文件 , 觉得可以在application中写, 如果没有那么多的话
 * @Author: yedong
 * @Date: 2019/10/7 21:33
 * @Modified by:
 */
@Configuration
@ComponentScan("com.design.demo.*")
public class MainConfig {
}
