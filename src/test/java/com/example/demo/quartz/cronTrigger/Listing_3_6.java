package com.example.demo.quartz.cronTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 1.一个Job可以对应 多个Trigger，但一个Trigger只能对应一个Job
 * <p>
 * 2.一个新的scheduler 或是处于standby状态的scheduler可以调用start方法
 *
 * @author Administrator
 */
public class Listing_3_6 {
    public Listing_3_6() {
    }

    public Scheduler createScheduler() throws SchedulerException {
        return StdSchedulerFactory.getDefaultScheduler();
    }

    public void scheduleJob(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(Q1.class).withIdentity("job1_1", "jGroup1").build();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put("num", "123");

        // cronTrigger 创建
        // 21:00 - 21:03 每分钟执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 40-43 01 * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger_1", "tGroup1")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    public static void main(String[] args) throws Exception {
        Listing_3_6 example = new Listing_3_6();
        Scheduler scheduler = example.createScheduler();
        example.scheduleJob(scheduler);
        scheduler.start();
    }
}
