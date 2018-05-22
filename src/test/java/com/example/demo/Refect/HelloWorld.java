package com.example.demo.Refect;

/**
 * Created by zhangyedong on 2017/12/3.
 */
public class HelloWorld {
    public static void main(String[] args) {
        String name = new HelloWorld().getClass().getName();
        System.out.println(name);

    }
}
