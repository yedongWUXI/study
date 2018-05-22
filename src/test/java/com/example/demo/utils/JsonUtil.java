package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyedong
 * @date 2018/2/9.
 */
public class JsonUtil {

    public static Object stringToBean(String strs, Class<?> clazz) {
        return JSONObject.parseObject(strs, clazz);
    }

    public static String bean2Json(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        Map map1 = new HashMap();


        for(int j = 0 ; j<10 ; j++){
            List listMin = new ArrayList();
            for(int i = 0 ; i< 10; i++){
                Map<String,String> map = new HashMap();
                map.put(j + i + "", i + j + "");
                listMin.add(map);
            }
            list.add(listMin);

        }

//        Object put = map1.put(0+"", 1+"");
//        Object put1 = map1.put(0+"", 2+"");
//        Object put2 = map1.put(0+"", 3+"");
//        Object put3 = map1.put(0+"", 4+"");

        String s = bean2Json(list);
        System.out.println(s);
        List o = (List)stringToBean(s, List.class);
        List o1 = (List)o.get(0);
        Map o2 = (Map)o1.get(0);
        String o3 = (String) o2.get("0");
        System.out.println(o3);
    }
}
