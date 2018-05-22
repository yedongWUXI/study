package com.example.demo.CglibProxy;

import org.mockito.cglib.proxy.Enhancer;

//import org.assertj.core.internal.cglib.proxy.Enhancer;

/**
 * Created by zhangyedong on 2017/12/5.
 */
public class Test {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(myProxy);
        Student st = (Student)enhancer.create();
        st.study();
    }
}
