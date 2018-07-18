package com.design.demo.Observe_designmodle;

/**
 * Created by zhangyedong on 2018/1/2.
 */
public class Test {
    @org.junit.Test
    public void test(){
        Teacher t = new Teacher();
        Student s = new Student();
        t.attach(s);
        t.notify("老师来了");
    }

}
