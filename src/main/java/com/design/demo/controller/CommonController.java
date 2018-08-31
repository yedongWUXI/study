package com.design.demo.controller;

import com.design.demo.config.ValueDemo;
import com.design.demo.domain.Student;
import com.design.demo.web.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyedong
 * @date 2018/2/9.
 */
@RestController
public class CommonController {
    @Autowired
    Test test;


    @Autowired
    ValueDemo valueDemo;
    @RequestMapping("one")
    public String aopTest(){

        return test.test();
    }

    @RequestMapping("two")
    public String valueTest(){
        valueDemo.init("1");
        return valueDemo.getDriver();
    }


    @RequestMapping("three")
    public String aopTest2() {
        Student student = new Student();
        student.setName("zs");
        return test.test2(student, "荡口高中", 0);
    }


}
