package com.design.demo.stategy_designmodle;

/**
 * Created by zhangyedong on 2018/1/10.
 */
public class ConcreteStrategyOne implements Strategy {
    @Override
    public void fly() {
        System.out.println("具体的策略实现2");
    }
}
