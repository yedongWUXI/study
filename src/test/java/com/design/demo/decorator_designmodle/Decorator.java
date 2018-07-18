package com.design.demo.decorator_designmodle;

/**
 * @author zhangyedong
 * @date 2018/3/5.
 */
public abstract class Decorator implements House {
    //持有被装饰对象引用
    public House house;

    public Decorator(House house) {
        this.house = house;
    }

    @Override
    public void paint() {
        house.paint();
    }

    @Override
    public void wallpaper() {
        house.wallpaper();
    }
}
