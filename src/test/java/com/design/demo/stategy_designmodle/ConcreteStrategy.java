package com.design.demo.stategy_designmodle;

/**
 * Created by zhangyedong on 2018/1/10.
 */
public class ConcreteStrategy implements Strategy {
    @Override
    public void fly() {
        System.out.println("具体的实现策略1");
    }
}
