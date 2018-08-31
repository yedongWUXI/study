package com.java.demo.stringpractice.string_utils;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

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



    @Test
    public void testStripEnd(){
        //去除后面的空格，（还有stripStart）
        String ss = StringUtils.stripEnd("ss                  ", "\0");
        System.out.println(ss);

        int end;
        if((end =1 )!= 0){
            System.out.println(11111);
        }

        System.out.println(end =1);

        end = 1;
    }

    @Test
    public void test1(){
        String str = "abcd";
        byte[] bs = str.getBytes();
        System.out.println(bs);
    }


    @Test
    public void test2(){
        String tranSerialNumber = getTranSerialNumber();
        System.out.println(tranSerialNumber);
    }

    public String getTranSerialNumber(){
        String date = "22222";
        //往左边填补，padStr:填补内容  size：填补后总长度
        String str = StringUtils.leftPad(date , 16 , "0");
        return str;
    }


    @Test
    public void StringFormate() {
        String str = null;
        str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");           // 格式化字符串
        System.out.println(str);                                                                                     // 输出字符串变量
        System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);
        System.out.printf("最牛的编号是：%03d%n", 7);
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        System.out.printf("一本书的价格是：%2.2f元%n", 49.8);
    }
}
