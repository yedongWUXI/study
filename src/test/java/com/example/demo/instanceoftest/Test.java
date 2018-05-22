package com.example.demo.instanceoftest;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangyedong on 2017/12/12.
 */
public class Test {
    @org.junit.Test
    @Transactional
    public void test(){
        //实现接口的子类 instanceof
        Student student = new Student();
        boolean b = student instanceof WorkInterface;
        System.out.println(b);

        //实现接口 instanceof
        WorkInterface wi = new Person();
        System.out.println(wi instanceof WorkInterface);
        //继承 instanceof
        Person st = new Student();
        boolean b1 = st instanceof Person;
        System.out.println(b1);




    }


}
