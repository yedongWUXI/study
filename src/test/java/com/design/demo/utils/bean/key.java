package com.design.demo.utils.bean;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/29 13:12
 * @Modified by:
 */
@Data
public class key {
    String test1;
    String test2;
    String test3;

    @Override
    public String toString() {
        return "TessClass{" +
                "test1='" + test1 + '\'' +
                ", test2='" + test2 + '\'' +
                ", test3='" + test3 + '\'' +
                '}';
    }
}
