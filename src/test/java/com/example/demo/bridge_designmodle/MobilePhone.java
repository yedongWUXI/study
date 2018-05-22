package com.example.demo.bridge_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/25.
 *
 * 桥接模式：业务抽象角色引用业务实现角色
 *
 * 业务抽象角色
 */
public  abstract  class MobilePhone {
    Function function;

    public void setFunction(Function function) {
        this.function = function;
    }

    abstract void useMobile();
}
