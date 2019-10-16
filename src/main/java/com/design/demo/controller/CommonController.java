package com.design.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.design.demo.config.ValueDemo;
import com.design.demo.config.bean.yedong;
import com.design.demo.domain.Student;
import com.design.demo.web.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhangyedong
 * @date 2018/2/9.
 */
@RestController
@RequestMapping(value = {"/common"})
@Api(tags = {"common相关"})
public class CommonController {
    @Autowired
    Test test;

    @Autowired
    yedong yedong;


    @Autowired
    ValueDemo valueDemo;

    @RequestMapping(value = "one", method = RequestMethod.POST)
    public String aopTest() {
        Student student = new Student("zs");
        String studentStr = JSONObject.toJSON(student).toString();
        return studentStr;
//        return test.test();
    }

    @RequestMapping(value = "two", method = RequestMethod.GET)
    public String valueTest() {
        valueDemo.init("1");
        System.out.println(yedong.getName());
        return valueDemo.getDriver();
    }


    @RequestMapping(value = "two_two", method = RequestMethod.GET)
    public String valueTestToDel(String s) {
        System.out.println(s);
        return s;
    }


    @RequestMapping(value = "three", method = RequestMethod.POST)
    @ApiOperation(value = "注销登录")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public String aopTest2() {
        Student student = new Student();
        student.setName("zs");
        return test.test2(student, "荡口高中", 0);
    }


    @RequestMapping(value = "four", method = RequestMethod.POST)
    @ApiOperation(value = "swaggerTest")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public String swaggerTest(String id) {
        return id;
    }


    @RequestMapping(value = "five", method = RequestMethod.GET)
    @ApiOperation(value = "swaggerTest")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="name", dataType = "string", value = "222")
//    })
    public String swaggerTest2(@RequestBody Map map) {
        return "success";
    }


    /**
     * @param id
     * @return
     * @PathVariable 见印象笔记HTTP@RequestParam和@PathVariable的区别
     */
    @PostMapping(value = "five/{id}")
    @ApiOperation(value = "swaggerTest")
    public String swaggerTest3(@PathVariable String id) {
        return "success" + id;
    }


    @RequestMapping(value = "globalException", method = RequestMethod.GET)
    @ApiOperation(value = "全局异常测试")
    public String globalException() {
        throw new NullPointerException();
    }


}
