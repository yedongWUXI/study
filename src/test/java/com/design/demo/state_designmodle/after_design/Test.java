package com.design.demo.state_designmodle.after_design;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Hero hero = new Hero();
        hero.startRun();
        hero.setState(Hero.SPEED_UP);
        Thread.sleep(5000);
        hero.setState(Hero.SPEED_DOWN);
        Thread.sleep(5000);
        hero.setState(Hero.SWIM);
        Thread.sleep(5000);
        hero.stopRun();
    }
}
