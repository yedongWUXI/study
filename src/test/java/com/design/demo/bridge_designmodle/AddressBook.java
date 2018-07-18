package com.design.demo.bridge_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/25.
 *
 * 业务实现角色
 */
public class AddressBook implements Function {
    @Override
    public void operation() {
        System.out.println("拥有手机通讯录");
    }
}
