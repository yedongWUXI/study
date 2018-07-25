package com.concurrence.thread;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/25 14:18
 * @Modified by:
 */

public class ShareTickets implements Runnable {
    private int totalNum = 15;

    /**
     * 1.当方法上面加上synchronized那么方法不走完，其他线程不能访问该方法
     * 2.如果是以某个对象，或者this在方法里，那么就是那个具体操作会线程安全
     */
    public void getTickets() {
        while (true) {
            synchronized (this) {
                if (totalNum > 0) {

                    totalNum--;
                    try {
                        Thread.sleep(2000);//用来扩大犯错概率
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "当前票的数量是" + totalNum);
                } else {
                    break;
                }
            }

        }
    }

    /**
     * 测试卖票出错事件
     */
    public void getTicketsNoSyn() {
        while (true) {
            if (totalNum > 0) {

                totalNum--;
                try {
                    Thread.sleep(2000);//用来扩大犯错概率
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "当前票的数量是" + totalNum);
            } else {
                break;
            }

        }
    }

    @Override
    public void run() {
//        getTickets();
        getTicketsNoSyn();
    }


    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        ShareTickets threadTest = new ShareTickets();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(threadTest);
            threads[i].start();
        }


    }
}
