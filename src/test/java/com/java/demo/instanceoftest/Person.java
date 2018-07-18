package com.java.demo.instanceoftest;

/**
 * Created by zhangyedong on 2017/12/12.
 */
public class Person implements WorkInterface {

    String name = "zs";
    @Override
    public void work() {
        System.out.println("人工作");
    }
}
