package com.common.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyedong
 * @date 2018/2/8.
 */
public class JsonTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        List<Integer> list1 = new ArrayList();
        list.add(4);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list.addAll(list1);
        System.out.println(list.toString());
        Integer[] objects = (Integer[]) list.toArray();
        Integer[] obj1  =  list.toArray(new Integer[3]);
//        System.out.println(objects1.toString());
        List<String> arr = new ArrayList<String>();

        arr.add("a");

        arr.add("b");

        arr.add("b");//可以添加重复的对象

        Object[] obj = arr.toArray();//第一种方法

        // String[] str = (String[])arr.toArray();//error

        String[] obj2 = arr.toArray(new String[3]);//第二种方法
    }
}
