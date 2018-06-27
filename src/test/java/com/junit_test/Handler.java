package com.junit_test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/6/27 13:26
 * @Modified by:
 */

public class Handler extends AbstractHandler {
    @Override
    public String handle() {
        return "junit extends test";
    }

    @Test
    public void test(){
        System.out.println("success");
    }

    @Before
    public void subClassBefore(){
        System.out.println("subClassBefore");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }
}
