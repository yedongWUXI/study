package com.example.demo.stringpractice.string_utils;

import java.util.StringTokenizer;

/**
 * @author zhangyedong
 * @date 2018/2/22.
 *
 * <p>
 * <tt>StringTokenizer</tt> is a legacy class that is retained for
 * compatibility reasons although its use is discouraged in new code. It is
 * recommended that anyone seeking this functionality use the <tt>split</tt>
 * method of <tt>String</tt> or the java.util.regex package instead.
 * <p>
 * 翻译：
 * StringTokenizer是出于兼容性的原因而被保留的遗留类（在新代码中并不鼓励使用它）
 * 建议使用String的split方法或者java.util.regex包
 */
public class StringTest {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("this is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }


        String[] result = "this is a test".split("\\s");
        for (int x = 0; x < result.length; x++)
            System.out.println(result[x]);
    }
}
