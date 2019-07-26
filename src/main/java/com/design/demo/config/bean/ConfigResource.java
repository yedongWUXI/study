package com.design.demo.config.bean;

import com.xxl.conf.core.annotation.XxlConf;
import org.springframework.stereotype.Component;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/21 2:11
 * @Modified by:
 */
@Component
public class ConfigResource {

    @XxlConf("testyedong.redis.port")
    public String redisPort;
    @XxlConf("testyedong.redis.ip")
    public String redisIp;

}
