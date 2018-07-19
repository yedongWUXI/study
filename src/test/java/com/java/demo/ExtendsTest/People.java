package com.java.demo.ExtendsTest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyedong on 2017/12/14.
 */
@NoArgsConstructor
@Data
public class People {

    static Map<String,String> map = new HashMap<>();
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
