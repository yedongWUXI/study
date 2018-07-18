package com.design.demo.stategy_designmodle.stategy_highlevel;

/**
 * Created by zhangyedong on 2018/1/14.
 *
 * 最终价格
 * Strategy
 *
 */
public interface CalPrice {
    //根据原价返回一个最终的价格
    Double calPrice(Double originalPrice);


}
