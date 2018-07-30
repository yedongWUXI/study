package com.concurrence.thread;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/27 15:06
 * @Modified by:
 */

public class ThreadTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println("ThreadTest");
        }
    }
}
