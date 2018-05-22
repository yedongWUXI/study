package com.example.demo.decorator_designmodle;

/**
 * @author zhangyedong
 * @date 2018/3/5.
 *
 * concreteComponent
 */
public class BedRoom implements House {
    @Override
    public void paint() {
        System.out.println("我要装饰卧室，打算刷点墙漆");
    }

    @Override
    public void wallpaper() {
        System.out.println("---------感觉还不太满意");
        System.out.println("我还打算贴点墙纸");
    }
}
