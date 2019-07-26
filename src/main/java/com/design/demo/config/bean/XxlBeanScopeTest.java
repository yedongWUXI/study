package com.design.demo.config.bean;

import com.design.demo.domain.Car;
import com.xxl.conf.core.annotation.XxlConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 测试xxlConfig的bean的作用域   结果：可以在@Configuration内使用
 * @Author: yedong
 * @Date: 2019/7/26 14:21
 * @Modified by:
 */
@Configuration
public class XxlBeanScopeTest {
    @XxlConf("testyedong.redis.port")
    public String redisPort;

    @Bean
    public Car getCar() {
        Car car = new Car();
        car.setMake(redisPort);
        System.out.println(redisPort + "======================");
        return car;
    }

}
