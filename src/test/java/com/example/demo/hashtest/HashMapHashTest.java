package com.example.demo.hashtest;

import org.junit.Test;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/18 14:03
 * @Modified by:
 */

public class HashMapHashTest {
    public static void main(String[] args) {
        String str = toBinary(10);
        System.out.println(str);
        Integer.parseInt(str,2);
        System.out.println("二进制转十进制:"+Integer.parseInt(str,2));

        System.out.println(13^55);

        System.out.println(1&2);
        System.out.println(2&2);

        System.out.println(5%2);
        System.out.println(55%2);
        System.out.println(522%2);
        System.out.println(6522%2);
        System.out.println(5522%2);
        System.out.println(5262%2);
        System.out.println("---------------");
        System.out.println(10%3);
        System.out.println(-17%10);
    }

    /**
     * 十进制转二进制规则：
     * 和二取余，再把得到的余数取反
     *
     * 比如8转二进制，第一次除以2等于4（余数0），第二次除以2等于2（余数0），第三次除以2等于1（余数0），最后余数1，得到的余数依次是0 0 0 1 ，
     * 反过来就是1000，计算机内部表示数的字节长度是固定的，比如8位，16位，32位。所以在高位补齐，java中字节码是8位的，所以高位补齐就是00001000.
     * @param num
     * @return
     */
    static String toBinary(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }





    @Test
    public void test(){
        int i = 5 ;
        System.out.println(i/2);
    }
}
