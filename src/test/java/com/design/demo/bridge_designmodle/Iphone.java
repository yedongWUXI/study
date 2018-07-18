package com.design.demo.bridge_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/25.
 */
public class Iphone extends MobilePhone {
    @Override
    void useMobile() {
        super.function.operation();
    }
}
