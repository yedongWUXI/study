package com.concurrence.thread;

import java.util.concurrent.Executor;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/27 15:06
 * @Modified by:
 */

public class ExecuteTest implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }


    public static void main(String[] args) {
        ExecuteTest executeTest = new ExecuteTest();
        executeTest.execute(new ThreadTest());
    }
}
