package com.design.demo.state_designmodle.after_design;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 */
public class CommonState implements RunState {
    @Override
    public void run(Hero hero) {
        //正常跑动则不打印内容，否则会刷屏
    }
}

class SpeedUpState implements RunState {
    @Override
    public void run(Hero hero) {
        System.out.println("--------------加速跑动---------------");
        try {
            Thread.sleep(4000);//假设加速持续4秒
        } catch (InterruptedException e) {
        }
        hero.setState(Hero.COMMON);
        System.out.println("------加速状态结束，变为正常状态------");
    }
}

class SpeedDownState implements RunState {
    @Override
    public void run(Hero hero) {
        System.out.println("--------------减速跑动---------------");
        try {
            Thread.sleep(4000);//假设减速持续4秒
        } catch (InterruptedException e) {
        }
        hero.setState(Hero.COMMON);
        System.out.println("------减速状态结束，变为正常状态------");
    }
}

class SwimState implements RunState {
    @Override
    public void run(Hero hero) {
        System.out.println("--------------不能跑动---------------");
        try {
            Thread.sleep(2000);//假设眩晕持续2秒
        } catch (InterruptedException e) {
        }
        hero.setState(Hero.COMMON);
        System.out.println("------眩晕状态结束，变为正常状态------");
    }
}
