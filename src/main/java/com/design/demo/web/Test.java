package com.design.demo.web;

import com.design.demo.domain.Student;

/**
 * @author zhangyedong
 * @date 2018/2/8.
 */
public class Test {
    @OperationLog(module = "中介成交",menu = "查询页面",operation = "查询")
    public String test(){
        return "aop test1";
    }

    @OperationLog(module = "中介成交", menu = "查询页面", operation = "查询")
    public String test2(Student student, String s, int type) {
        return "aop test1";
    }


}
