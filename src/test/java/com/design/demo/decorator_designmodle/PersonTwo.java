package com.design.demo.decorator_designmodle;

/**
 * @author zhangyedong
 * @date 2018/3/5.
 *
 * ConcreteDecorator
 */
public class PersonTwo extends Decorator {
    public PersonTwo(House house) {
        super(house);
    }

    @Override
    public void paint() {
        super.paint();
        System.out.println("墙漆的用量勾兑，搅匀");
    }

    @Override
    public void wallpaper() {
        super.wallpaper();
        System.out.println("剪裁墙纸");
    }

}
