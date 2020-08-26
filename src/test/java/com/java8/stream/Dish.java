package com.java8.stream;

import lombok.Data;

/**
 * @author zhangyedong
 * @date 2018/7/3.
 */
@Data
public class Dish {
    private String name;
    private Boolean vegetarian;
    private int calories;
    private Type type;


    public Dish(String name, Boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    enum Type {
        MEAT, FISH, OTHER
    }


}
