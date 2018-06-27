package com.junit_test;

import org.junit.Before;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/6/27 13:21
 * @Modified by:
 */

public abstract class AbstractHandler {
    public abstract String handle();

    @Before
    public void before(){
        this.printOut(handle());
    }

    public void printOut(String s){
        System.out.println(s);
    }
}
