package com.design.demo.stategy_designmodle;

/**
 * Created by zhangyedong on 2018/1/10.
 */
public class Test {
    @org.junit.Test
    public  void test1(){
        Context context = new Context();
        context.setStrategy(new ConcreteStrategy());
        context.operation();
        context.setStrategy(new ConcreteStrategyOne());
        context.operation();
    }
}
