package com.design.demo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/5/27 9:44
 * @Modified by:
 */
@RestController
@RequestMapping(value = "modelController")
public class ModelController {

    //一开始进入Controller执行该方法
//    @ModelAttribute
//    public void getUser(@RequestParam(value = "userName", required = false) String userName, Model model) {
//
//        Car car = Car.nonNullArgsMethod(userName, "");
//        model.addAttribute("user", car);
//    }
//    @ModelAttribute注解getUser方法,getUser方法接收前台提交的userName数据,在model中放入user属性和数据。

    //真正的请求url
    @RequestMapping(value = "/testModelAttribute", method = RequestMethod.POST)
    public String testModelAttribute(ModelMap model) {
        System.out.println("testModelAttribute user:" + model.get("user"));
        return "success";

    }

    //真正的请求url
    @RequestMapping(value = "testModelAttribute1")
    public String testModelAttribute1() {
        return "success";

    }
}
