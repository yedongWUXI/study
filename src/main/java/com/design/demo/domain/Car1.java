package com.design.demo.domain;

/**
 * Created by zhangyedong on 2017/11/30.
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yedong
 */
@Data
@AllArgsConstructor
public class Car1 {

    private String make;
    private String model;
    private int year;
    private Long id;


}

