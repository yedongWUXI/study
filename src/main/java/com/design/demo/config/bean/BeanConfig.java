package com.design.demo.config.bean;

import com.design.demo.config.configbean.CarPlugn;
import com.design.demo.config.configbean.Iplugn;
import com.design.demo.config.configbean.StudentPlugn;
import com.design.demo.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2021/6/4 9:16
 * @Modified by:
 */
@Configuration
public class BeanConfig {

    @Bean
    public CarPlugn carPlugn(){
        return new CarPlugn();
    }


    @Bean
    public StudentPlugn studentPlugn(){
        return new StudentPlugn();
    }




    //这里 入参是list  就是上面的两个Bean
    @Bean
    public Car car(List<Iplugn> list){
        System.out.println(list.toString());
        return null;

    }

}
