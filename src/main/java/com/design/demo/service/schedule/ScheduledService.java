//package com.design.demo.service.schedule;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @Description: java类作用描述
// * @Author: yedong
// * @Date: 2019/5/31 12:26
// * @Modified by:
// */
//
//@Slf4j
//@Component
//public class ScheduledService {
//    @Scheduled(cron = "0/5 * * * * *")
//    public void scheduled() {
//        log.info("=====>>>>>使用cron  {}", System.currentTimeMillis());
//    }
//
//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
//    }
//
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled2() {
//        log.info("=====>>>>>fixedDelay{}", System.currentTimeMillis());
//    }
//}