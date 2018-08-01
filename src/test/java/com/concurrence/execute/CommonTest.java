package com.concurrence.execute;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/8/1 13:33
 * @Modified by:
 */

public class CommonTest {
    public static void main(String[] args) {
    }

    /**
     * newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
     * <p>
     * 运行结果：总共只会创建5个线程， 开始执行五个线程，当五个线程都处于活动状态，
     * 再次提交的任务都会加入队列等到其他线程运行结束，当线程处于空闲状态时会被下一个任务复用
     */
    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = () -> System.out.println(Thread.currentThread().getName());
            executorService.execute(syncRunnable);
        }
    }

    /**
     * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
     * <p>
     * 运行结果：可以看出缓存线程池大小是不定值，可以需要创建不同数量的线程，在使用缓存型池时，
     * 先查看池中有没有以前创建的线程，如果有，就复用.如果没有，就新建新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
     */
    @Test
    public void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Runnable syncRunnable = () -> System.out.println(Thread.currentThread().getName());
            executorService.execute(syncRunnable);
        }
    }

    /**
     * schedule(Runnable command,long delay, TimeUnit unit)创建并执行在给定延迟后启用的一次性操作
     * <p>
     * 运行结果和newFixedThreadPool类似，不同的是newScheduledThreadPool是延时一定时间之后才执行
     */
    @Test
    public void test2() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = () -> System.out.println(Thread.currentThread().getName());
            executorService.schedule(syncRunnable, 500, TimeUnit.MILLISECONDS);
            try {
                Thread.sleep(1000);//让主线程慢点结束，不然上面的线程没时间执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；
     * 也就是将在 initialDelay 后开始执行，然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推
     *
     * PS:不受计划执行时间的影响。到时间，它就执行
     */
    @Test
    public void test3() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        Runnable syncRunnable = () -> System.out.println(Thread.currentThread().getName());
        executorService.scheduleAtFixedRate(syncRunnable, 5000, 3000, TimeUnit.MILLISECONDS);
        try {
            executorService.awaitTermination(20000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟
     *
     * PS:受计划执行时间的影响,无论某个任务执行多长时间，等执行完了，我再延迟指定的时间
     */
    @Test
    public void test4() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        Runnable syncRunnable = () -> System.out.println(Thread.currentThread().getName());
        executorService.scheduleWithFixedDelay(syncRunnable, 5000, 3000, TimeUnit.MILLISECONDS);
        try {
            executorService.awaitTermination(20500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     *
     * 运行结果：只会创建一个线程，当上一个执行完之后才会执行第二个
     */
    @Test
    public void test5() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = () -> System.out.println(Thread.currentThread().getName());
            executorService.execute(syncRunnable);
        }

    }






}