package com.design.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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

    /**
     * 拉平Json里的datas，数组直接拉出来，对象把最底层的叶子全拉出来
     *
     * @param json
     */
    public static void flatJson(JSONObject json) {
        JSONObject res = new JSONObject();
        scanJSON(json.getJSONObject("Datas"), res);
        json.put("Datas", res);
    }

    private static void scanJSON(JSONObject json, JSONObject res) {
        json.forEach((k, v) -> {
            if (v instanceof JSONObject) {
                scanJSON((JSONObject) v, res);
            } else if (v instanceof JSONArray) {
                res.put(k, v);
            } else {
                res.put(k, v);
            }

        });
    }

    public static void main(String[] args) {

    }
}
