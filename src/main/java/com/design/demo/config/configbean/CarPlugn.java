package com.design.demo.config.configbean;

import lombok.Data;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2021/6/4 9:19
 * @Modified by:
 */
@Data
public class CarPlugn implements Iplugn {
    String id;
    String name;

    public CarPlugn() {
        this.id = "1";
        this.name = "BYD";
    }
}
