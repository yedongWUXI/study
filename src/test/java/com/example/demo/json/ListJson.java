package com.example.demo.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyedong
 * @date 2018/2/4.
 *
 * 在json中 数组 代表了 java中的数组和集合
 */
public class ListJson {
    @Test
    public void test(){
        System.out.println("List<Integer> ===========================");
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        String listInteger = JSONObject.toJSON(list).toString();
        System.out.println(listInteger);

        System.out.println("数组[Integer]==========================");
        Integer[] str = new Integer[8];
        str[0] = 1;
        str[1] = 2;
        str[2] = 3;
        str[3] = 4;
        str[4] = 5;
        str[5] = 6;
        str[6] = 7;
        str[7] = 8;
        String s1 = JSONObject.toJSON(str).toString();
        System.out.println(s1);


        System.out.println("List<String> ===========================");
        List<String> list1 = new ArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        String s2 = JSONObject.toJSON(list1).toString();
        System.out.println(s2);

        System.out.println("数组[String]==========================");
        String[] str1 = new String[8];
        str1[0] = "1";
        str1[1] = "2";
        str1[2] = "3";
        str1[3] = "4";
        str1[4] = "5";
        str1[5] = "6";
        str1[6] = "7";
        str1[7] = "8";
        String s3 = JSONObject.toJSON(str1).toString();
        System.out.println(s3);


        System.out.println("list对象==========================");
        List<Student> listSt = new ArrayList();
        listSt.add(new Student("zs",1));
        listSt.add(new Student("ls",2));
        listSt.add(new Student("ww",3));
        listSt.add(new Student("zl",4));
        listSt.add(new Student("wb",5));
        String s4 = JSONObject.toJSON(listSt).toString();
        System.out.println(s4);

        System.out.println("数组对象==========================");
        Student[] students = new Student[5];
        students[0]= new Student("zs",1);
        students[1]= new Student("ls",2);
        students[2]= new Student("ww",3);
        students[3]= new Student("zl",4);
        students[4]= new Student("wb",5);
        String s5 = JSONObject.toJSON(students).toString();
        System.out.println(s5);

        System.out.println("map==========================");
        Map map = new HashMap();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");
        map.put("6","6");
        map.put("7","7");
        map.put("8","8");
        String s6 = JSONObject.toJSON(map).toString();
        System.out.println(s6);



    }
}
