package com.java.demo.ExtendsTest;

import lombok.NoArgsConstructor;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/13 14:36
 * @Modified by:
 */
@NoArgsConstructor
public class XiaoMing extends Student {

    public static void main(String[] args) {
        XiaoMing xm = new XiaoMing();
        xm.eat();//在继承关系中，当多重继承的时候，调用的是最近的父类的方法
    }

    public void updateMap(){
        map.clear();
        map.put("XiaoMing","2");
    }


}
