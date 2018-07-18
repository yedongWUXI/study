package com.design.demo.quartz.simpleTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * 1.一个Job可以对应 多个Trigger，但一个Trigger只能对应一个Job
 * <p>
 * 2.一个新的scheduler 或是处于standby状态的scheduler可以调用start方法
 *
 * @author Administrator
 */
public class Listing_3_5 {
    public Listing_3_5() {
    }

    public Scheduler createScheduler() throws SchedulerException {
        return StdSchedulerFactory.getDefaultScheduler();
    }

    @SuppressWarnings("static-access")
    public void scheduleJob(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(Q1.class).withIdentity("job1_1", "jGroup1").build();

        JobDataMap jobDataMap = jobDetail.getJobDataMap();

        jobDataMap.put("para1", "hello");

        // 一个scheduler 可以绑定多个job
        // 一个 Job 在同一个 Scheduler 实例中通过名称和组名能唯一被标识
        // 每5秒执行一次,共执行四次(注意参数为3)
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)
                .withRepeatCount(3);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_1", "tGroup1").startNow()
                .withSchedule(builder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public static void main(String[] args) throws Exception {
        Listing_3_5 example = new Listing_3_5();
        Scheduler scheduler = example.createScheduler();
        example.scheduleJob(scheduler);
        scheduler.start();
    }
}