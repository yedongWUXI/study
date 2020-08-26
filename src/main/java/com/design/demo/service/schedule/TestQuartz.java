package com.design.demo.service.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/5/31 12:36
 * @Modified by:
 */

public class TestQuartz extends QuartzJobBean {
    /**
     * 执行定时任务
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task " + new Date());
    }
}