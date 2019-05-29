package com.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/26 15:51
 * @Modified by:
 */

public class MyJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("MyJob  is start ..................");

        log.info("Hello quzrtz  " +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

        log.info("MyJob  is end .....................");
    }
}
