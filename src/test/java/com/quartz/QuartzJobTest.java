package com.quartz;


import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/29 22:46
 * @Modified by:
 */

public class QuartzJobTest {
    Logger logger = Logger.getLogger(QuartzJobTest.class);

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


        scheduler.start();
    }

}
