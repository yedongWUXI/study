package com.concurrence.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/24 16:11
 * @Modified by:
 */

public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(50);

        ArrayBlockingQueue<CustomizedTask> tasksQueue = new ArrayBlockingQueue<>(100);//有界队列 100个元素
        // 生产者线程
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    tasksQueue.put(new CustomizedTask());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            CustomizedTask task;
            try {
                while ((task = tasksQueue.take()) != null && !Thread.currentThread().isInterrupted()) {
                    ex.submit(task);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("Main Thread is terminated");
    }

    static class CustomizedTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }
}
