package com.example.demo.domain;

/**
 * Created by zhangyedong on 2017/11/30.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yedong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String make, model;
    private int year;
    private Long id;

}

