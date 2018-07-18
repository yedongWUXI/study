package com.design.demo.state_designmodle.after_design;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 *
 * 用状态模式改造后
 *
 * 特点：将所有与一个特定的状态相关的行为（行为类）都放入一个对象中
 *
 * 简单点讲就是成员变量依赖
 *
 */
public class Hero {
    public static final RunState COMMON = new CommonState();//正常状态

    public static final RunState SPEED_UP = new SpeedUpState();//加速状态

    public static final RunState SPEED_DOWN = new SpeedDownState();//减速状态

    public static final RunState SWIM = new SwimState();//眩晕状态

    private RunState state = COMMON;//默认是正常状态

    private Thread runThread;//跑动线程

    //设置状态
    public void setState(RunState state) {
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
                    state.run(hero);
                }
            }
        });
        System.out.println("--------------开始跑动---------------");
        runThread.start();
    }

    private boolean isRunning(){
        return runThread != null && !runThread.isInterrupted();
    }
}
