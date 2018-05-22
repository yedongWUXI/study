package com.example.demo.controller;

import com.example.demo.web.Test;
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
    @RequestMapping("one")
    public String aopTest(){

        return test.test();
    }
}
