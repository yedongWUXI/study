package com.java_dark;

/**
 * @Description: shutdownThread
 * @Author: wxzhangyd
 * @Date: 2018/9/13 14:36
 * @Modified by:
 */

public class RunTimeTest {
    /**
     * 打印结果：
     * <p>
     * thread2...
     * thread1...
     * shutdownThread...
     * <p>
     * <p>
     * 或者：
     * <p>
     * thread2...
     * thread1...
     * shutdownThread...
     * <p>
     * <p>
     * 结论：
     * <p>
     * <p>
     * <p>
     * 无论是先打印thread1还是thread2，shutdownThread 线程都是最后执行的（因为这个线程是在jvm执行关闭前才会执行）。
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("thread1 start"));
        Thread thread2 = new Thread(() -> System.out.println("thread2 start"));

        Thread threadShutDown = new Thread(() -> System.out.println("thread  ShutDown"));
        // jvm关闭的时候先执行该线程钩子
        Runtime.getRuntime().addShutdownHook(threadShutDown);
        thread1.start();
        thread2.start();


    }
}
