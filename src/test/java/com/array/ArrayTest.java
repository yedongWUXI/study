package com.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/25 10:54
 * @Modified by:
 */

public class ArrayTest {
    @Test
    public void test(){
        int[] ints = {1,2,3,4,5,67,1,3};
        int[] intsByLen = new int[10];
        int[] intsDistinct = Arrays.stream(ints).distinct().toArray();
        for (int i = 0; i < intsDistinct.length; i++) {
            System.out.println(intsDistinct[i]);
        }

        String[] strings = {"a","b","c","d","e","f","a","b"};
        Object[] objects = Arrays.stream(strings).distinct().toArray();
        for (int i = 0; i < objects.length ; i++) {
            System.out.println((String) objects[i]);
        }


    }
}
