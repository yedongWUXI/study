package com.json.jsonpath;

import com.alibaba.fastjson.JSONPath;

import java.util.List;

/**
 * @Description: JSONPath
 * @Author: wxzhangyd
 * @Date: 2018/9/11 10:38
 * @Modified by:
 */

public class TestJSONPath {
    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"store\": {\n" +
                "\t\t\"book\": [{\n" +
                "\t\t\t\t\"title\": \"高效Java\",\n" +
                "\t\t\t\t\"price\": 10\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"title\": \"研磨设计模式\",\n" +
                "\t\t\t\t\"price\": 12\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"title\": \"重构\",\n" +
                "\t\t\t\t\"isbn\": \"553\",\n" +
                "\t\t\t\t\"price\": 8\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"title\": \"虚拟机\",\n" +
                "\t\t\t\t\"isbn\": \"395\",\n" +
                "\t\t\t\t\"price\": 22\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"bicycle\": {\n" +
                "\t\t\t\"title\": \"高效Linux\",\n" +
                "\t\t\t\"color\": \"red\",\n" +
                "\t\t\t\"price\": 19\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";


        // 获取json中store下book下的所有title值
        List<Object> titles = (List<Object>) JSONPath.read(json, "$.store.book.title");
        System.out.println("$.store.book.title = " + titles);

        // 获取json中所有title的值
        titles = (List<Object>) JSONPath.read(json, "$..title");
        System.out.println("$..title = " + titles);

        // 获取json中book数组中包含isbn的所有值
        List<Object> isbns = (List<Object>) JSONPath.read(json, "$.store.book[?(@.isbn)]");
        System.out.println("$.store.book[?(@.isbn)] = " + isbns);

        // 获取json中book数组中price<10的所有值
        List<Object> prices = (List<Object>) JSONPath.read(json, "$.store.book[?(@.price < 10)]");
        System.out.println("$.store.book[?(@.price < 10)] = " + prices);

        // 获取json中book数组中的title等于“高效Java”的对象
        titles = (List<Object>) JSONPath.read(json, "$.store.book[?(@.title = '高效Java')]");
        System.out.println("$.store.book[?(@.title = '高效Java')] = " + titles);

        // 获取json中store下所有price的值
        prices = (List<Object>) JSONPath.read(json, "$.store..price");
        System.out.println("$.store..price = " + prices);

        // 获取json中book数组的前两个区间值
        List<Object> books = (List<Object>) JSONPath.read(json, "$.store.book[:2]");
        System.out.println("$.store.book[:2] = " + books);

        // 获取书个数
        int size = (int) JSONPath.read(json, "$.store.book.size()");
        System.out.println("$.store.book.size() = " + size);
    }
}
