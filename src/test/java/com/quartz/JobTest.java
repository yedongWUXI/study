package com.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/29 22:44
 * @Modified by:
 */

public class JobTest implements Job {

    Logger logger = Logger.getLogger(JobTest.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("JobTest start");
    }
}
