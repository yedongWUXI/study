package com.design.demo.domain;

/**
 * Created by zhangyedong on 2017/11/30.
 */

import lombok.*;

/**
 * @author yedong
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "nonNullArgsMethod", access = AccessLevel.PUBLIC)//生成有@NonNull参数的构造函数
public class Car {

    @NonNull
    public String make;
    @NonNull
    public String model;
    public int year;
    public Long id;


    public static void main(String[] args) {
        //@RequiredArgsConstructor
        Car newCar = new Car("", "");
        //staticName = "nonNullArgsMethod"
        Car car = Car.nonNullArgsMethod("", "");
        //@Builder
        Car build = Car.builder().build();
    }

}

