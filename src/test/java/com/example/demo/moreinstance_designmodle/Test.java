package com.example.demo.moreinstance_designmodle;

import java.util.Random;

/**
 * @author zhangyedong
 * @date 2018/1/28.
 */
public class Test {
    @org.junit.Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.println(emperor.getName());
        }
    }

    @org.junit.Test
    public void test1() {
        int i = 5;
        Random random = new Random();
        for (int j = 0; j < 100; j++) {
            int i1 = random.nextInt(i);
            System.out.println(i1);
        }
    }
}
