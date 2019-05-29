package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/26 15:17
 * @Modified by:
 */

public class RAMJob implements Job {

    private static Logger logger = LoggerFactory.getLogger(RAMJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("hello,quartz", new Date());

    }
}
