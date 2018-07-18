package com.design.demo.state_designmodle;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 *
 *
 * 没改造前
 *
 */
public class Hero {
    public static final int COMMON = 1;//正常状态

    public static final int SPEED_UP = 2;//加速状态

    public static final int SPEED_DOWN = 3;//减速状态

    public static final int SWIM = 4;//眩晕状态

    private int state = COMMON;//默认是正常状态

    private Thread runThread;//跑动线程

    //设置状态
    public void setState(int state) {
        this.state = state;
    }

    //停止跑动
    public void stopRun() {
        if (isRunning()) runThread.interrupt();
        System.out.println("--------------停止跑动---------------");
    }

    //开始跑动
    public void startRun() {
        if (isRunning()) {
            return;
        }
        final Hero hero = this;
        runThread = new Thread(new Runnable() {
            public void run() {
                while (!runThread.isInterrupted()) {
                    try {
                        hero.run();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });
        System.out.println("--------------开始跑动---------------");
        runThread.start();
    }

    private boolean isRunning() {
        return runThread != null && !runThread.isInterrupted();
    }

    //英雄类开始奔跑
    private void run() throws InterruptedException {
        if (state == SPEED_UP) {
            System.out.println("--------------加速跑动---------------");
            Thread.sleep(4000);//假设加速持续4秒
            state = COMMON;
            System.out.println("------加速状态结束，变为正常状态------");
        } else if (state == SPEED_DOWN) {
            System.out.println("--------------减速跑动---------------");
            Thread.sleep(4000);//假设减速持续4秒
            state = COMMON;
            System.out.println("------减速状态结束，变为正常状态------");
        } else if (state == SWIM) {
            System.out.println("--------------不能跑动---------------");
            Thread.sleep(2000);//假设眩晕持续2秒
            state = COMMON;
            System.out.println("------眩晕状态结束，变为正常状态------");
        } else {
            //正常跑动则不打印内容，否则会刷屏
        }
    }

}
