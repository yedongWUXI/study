package com.design.demo.stategy_designmodle.stategy_highlevel;

/**
 * Created by zhangyedong on 2018/1/14.
 */
public class Test {
    @org.junit.Test
    public void test(){
        Customer customer = new Customer();
        customer.buy(10000.00);
        Double moneyToPay = customer.calLastAmount();
        System.out.println(moneyToPay);
    }
}
