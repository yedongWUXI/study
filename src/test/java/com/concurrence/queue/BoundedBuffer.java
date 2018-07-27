package com.concurrence.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/25 9:18
 * @Modified by:
 */

public class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    transient int putptr, takeptr, count;


    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {

            while (true) {

                items[putptr] = x;
                if (++putptr == items.length) {

                    putptr = 0;
                    ++count;
                }

                if (count == items.length) {

                    notFull.await();
                }
                System.out.println("put" + count);
                notEmpty.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        lock.lock();
        try {

            while (true) {

                Object x = items[takeptr];

                if (++takeptr == items.length) takeptr = 0;
                --count;
                System.out.println("take" + count);
                if (count == 0) {

                    notEmpty.await();
                }
                notFull.signal();
            }

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedBuffer.put("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedBuffer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
    }
}
