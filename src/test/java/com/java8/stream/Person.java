package com.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/8/9 11:34
 * @Modified by:
 */
@Data
@AllArgsConstructor
public class Person {
    private String DishName;
    private Integer id;
    private String name;

    private Integer dishCalories;

    public Person(String dishName, Integer id, String name) {
        DishName = dishName;
        this.id = id;
        this.name = name;
    }
}
