package com.radix_demo;

import org.junit.Test;

/**
 * @Description: java最基础
 * @Author: wxzhangyd
 * @Date: 2018/7/9 13:40
 * @Modified by:
 */

public class CommonTest {
    @Test
    public void test(){
        /**
         * radix 多少进制
         */
        int i = Integer.parseInt("1010", 2);
        System.out.println(i);
    }

    /**
     * 测试为什么byte 0x80是-128
     */
    @Test
    public void test1() {
        byte[] bytes = new byte[10];
        bytes[0] = (byte) 0x80;
        //因为byte的范围是-128~127 0x80超出了范围，所以补位到-128
        System.out.println(bytes[0]);
        int i = 0x80;
        int a = -128;
        System.out.println(i == a);


    }


    @Test
    public void test2() {
        String srt = "01110110";

        Integer result = Integer.valueOf(srt.substring(0, 3), 2);
        System.out.println(result);
    }
}
