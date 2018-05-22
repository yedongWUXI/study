package com.example.demo.quartz.cronTrigger;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangyedong
 * @date 2018/3/19.
 */
//实现了job接口的Q1 job
public class Q1 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        System.out.println(sdf.format(new Date()));
        // 获取jobDetail 中的参数
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String para1 = jobDataMap.getString("para1");
        System.out.println("jobDataMap中的para1:" + para1);
        System.out.println("------------------------");
    }

}
