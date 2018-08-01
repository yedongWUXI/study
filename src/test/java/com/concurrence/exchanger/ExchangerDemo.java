package com.concurrence.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger工具类则提供了在线程之间交换数据的一种手段。
 *
 * Exchanger 提供一个同步点，在这个同步点处，两个线程可以交换彼此数据。即一个线程调用了exchange( )方法交换数据，
 * 到达了同步点，然后就会一直阻塞等待另一个线程调用exchange( )方法来交换数据。所以，要注意exchange( )方法是有阻塞的特性。
 *
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/8/1 10:00
 * @Modified by:
 */

public class ExchangerDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        final Exchanger exchanger = new Exchanger();
        //下面两个交换
        executor.execute(new Runnable() {
            String data1 = "克拉克森，小拉里南斯";


            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });


        executor.execute(new Runnable() {
            String data1 = "格里芬";

            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });


        //下面两个交换
        executor.execute(new Runnable() {
            String data1 = "哈里斯";

            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });

        executor.execute(new Runnable() {
            String data1 = "以赛亚托马斯，弗莱";

            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });

        executor.shutdown();
    }

    private static void nbaTrade(String data1, Exchanger exchanger) {
        try {
            System.out.println(Thread.currentThread().getName() + "在交易截止之前把 " + data1 + " 交易出去");
            Thread.sleep((long) (Math.random() * 1000));

            String data2 = (String) exchanger.exchange(data1);
            System.out.println(Thread.currentThread().getName() + "交易得到" + data2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
