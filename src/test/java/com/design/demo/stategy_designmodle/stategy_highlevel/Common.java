package com.design.demo.stategy_designmodle.stategy_highlevel;

/**
 * Created by zhangyedong on 2018/1/14.
 *
 * concreteStrategy
 */
@TotalValidRegion(max=1000)
public class Common implements CalPrice {
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }

}
@TotalValidRegion(min=1000,max=2000)
class Vip implements CalPrice {

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }

}
@TotalValidRegion(min = 2000,max = 3000)
class SuperVip implements CalPrice {

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }

}
@TotalValidRegion(min=3000)
class GoldVip implements CalPrice {

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }
}
