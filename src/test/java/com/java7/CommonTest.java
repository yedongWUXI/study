package com.java7;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 详情看Objects的API，里面很详细
 * @Author: wxzhangyd
 * @Date: 2018/9/5 16:03
 * @Modified by:
 */

public class CommonTest {
    @Test
    public void test() {
        Objects.requireNonNull("Object", "Object must not be null");
    }

    @Test
    public void testMap() {
        Map map = new HashMap();
        map.put("a", "2");
        map.put("a", "3");
        System.out.println(map.get("a"));
    }
}
