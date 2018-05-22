package com.example.demo.decorator_designmodle;

/**
 * @author zhangyedong
 * @date 2018/3/5.
 *
 * ConcreteDecorator
 */
public class PersonOne extends Decorator {
    public PersonOne(House house) {
        super(house);
    }

    @Override
    public void paint() {
        super.paint();
        System.out.println("选购墙漆");
    }

    @Override
    public void wallpaper() {
        super.wallpaper();
        System.out.println("选购墙纸");
    }
}
