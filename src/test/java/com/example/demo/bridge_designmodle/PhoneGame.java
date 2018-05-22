package com.example.demo.bridge_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/25.
 *
 * 业务实现角色
 */
public class PhoneGame implements Function {
    @Override
    public void operation() {
        System.out.println("拥有手机游戏");
    }
}
