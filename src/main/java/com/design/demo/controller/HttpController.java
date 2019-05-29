package com.design.demo.controller;

import com.design.demo.domain.Car;
import com.design.demo.utils.HttpUtil;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/4/22 1:23
 * @Modified by:
 */

@RestController
public class HttpController {

    String url = "http://localhost:8004/study/testHttpclient_modelAttribute";

    @RequestMapping("/testHttpclient")
    public String queryDept(HttpServletRequest request, HttpSession session) {


        String result = HttpUtil.doPost(url);


        return result;


    }


    @RequestMapping("/testHttpclient_modelAttribute")
    public String testHttpclient_modelAttribute(@ModelAttribute Car car) {


        System.out.println(car.toString());

        return "success";


    }


    @RequestMapping("test")
    public String getSuccess() {
        return "success";
    }
}
