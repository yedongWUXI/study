package com.design.demo.web;

/**
 * @author zhangyedong
 * @date 2018/2/8.
 */
public class Test {
    @OperationLog(module = "中介成交",menu = "查询页面",operation = "查询")
    public String test(){
        return "aop test1";
    }


}
