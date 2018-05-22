package com.example.demo.stategy_designmodle;

/**
 * Created by zhangyedong on 2018/1/10.
 *
 * 与状态模式的区别是使用传参依赖，根据客户端的传参，多态调用
 *
 */
public class Context {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void operation(){
        strategy.fly();
    }
}
