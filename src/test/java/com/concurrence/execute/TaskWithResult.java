package com.concurrence.execute;

import java.util.concurrent.Callable;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/8/1 16:36
 * @Modified by:
 */

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
     * 则该方法自动在一个线程上执行
     */
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        //该返回结果将被Future的get方法得到
        return  id + ":    " + Thread.currentThread().getName();
    }
}
