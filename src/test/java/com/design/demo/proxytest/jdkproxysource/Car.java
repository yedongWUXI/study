package com.design.demo.proxytest.jdkproxysource;

/**
 * Created by zhangyedong on 2017/12/7.
 */
public class Car implements Moveable {
    @Override
    public void move() throws Exception {
        System.out.println("汽车行驶中...");
    }
}
