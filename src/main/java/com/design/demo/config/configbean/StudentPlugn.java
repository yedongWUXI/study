package com.design.demo.config.configbean;

import lombok.Data;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2021/6/4 9:19
 * @Modified by:
 */
@Data
public class StudentPlugn implements Iplugn {

    String id;
    String name;

    public StudentPlugn() {
        this.id = "1";
        this.name = "张三";
    }
}
