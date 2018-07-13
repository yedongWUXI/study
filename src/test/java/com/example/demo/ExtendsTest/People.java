package com.example.demo.ExtendsTest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by zhangyedong on 2017/12/14.
 */
@NoArgsConstructor
public class People {
    String name;

    public People(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public void eat(){
        System.out.println("everyone to eat");
    }

    public String getName() {
        return name;
    }
}
