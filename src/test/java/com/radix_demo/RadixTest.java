package com.radix_demo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/7/16 17:59
 * @Modified by:
 */

public class RadixTest {
    @Test
    public void test(){
        Byte bt = new Byte("10");
        System.out.println(bt.byteValue());
        String s = Integer.toBinaryString(10);
        System.out.println(s);
        String s1 = new String("00000905001100009765LZYTDGDF9F1013037   015724972842                     0000082400041D0001020102018F00041000830B157249728423508000C000109100000000000000000020101301114010030900000000004090000000000505000003304000006040000010C17112806073110085A1C8CA31E0802653DD83605000000702007D0400001208000002D42A030143105000003908000000004508000044005302005A0400005B08011400005C02FF5E02FF1508000001A4180800000AC843030005F080000000056020057020055080000000061080005201C620800000000540200630800000000640400006504000002018F00041000830B157249728423508000C000109100000000000000000020101301114010030900000000004090000000000505000003304000006040000010C17112806073110085A1C8CA31E0802653DD83605000000702007D0400001208000002D42A030143105000003908000000004508000044005302005A0400005B08011400005C02FF5E02FF1508000001A4180800000AC843030005F080000000056020057020055080000000061080005201C6208000000005402006308000000006404000065040000");
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = {48, 48, 48, 48, 48, 57, 48, 53, 48, 48, 49, 49, 48, 48, 48, 48, 57, 55, 54, 53, 76, 90, 89, 84, 68, 71, 68, 70, 57, 70, 49, 48, 49, 51, 48, 51, 55, 32, 32, 32, 48, 49, 53, 55, 50, 52, 57, 55, 50, 56, 52, 50, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 48, 48, 48, 48, 56, 50, 52, 48, 48, 48, 52, 49, 68, 48, 48, 48, 49, 48, 50, 48, 49, 48, 50, 48, 49, 56, 70, 48, 48, 48, 52, 49, 48, 48, 48, 56, 51, 48, 66, 49, 53, 55, 50, 52, 57, 55, 50, 56, 52, 50, 51, 53, 48, 56, 48, 48, 48, 67, 48, 48, 48, 49, 48, 57, 49, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 50, 48, 49, 48, 49, 51, 48, 49, 49, 49, 52, 48, 49, 48, 48, 51, 48, 57, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 52, 48, 57, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 53, 48, 53, 48, 48, 48, 48, 48, 51, 51, 48, 52, 48, 48, 48, 48, 48, 54, 48, 52, 48, 48, 48, 48, 48, 49, 48, 67, 49, 55, 49, 49, 50, 56, 48, 54, 48, 55, 51, 49, 49, 48, 48, 56, 53, 65, 49, 67, 56, 67, 65, 51, 49, 69, 48, 56, 48, 50, 54, 53, 51, 68, 68, 56, 51, 54, 48, 53, 48, 48, 48, 48, 48, 48, 55, 48, 50, 48, 48, 55, 68, 48, 52, 48, 48, 48, 48, 49, 50, 48, 56, 48, 48, 48, 48, 48, 50, 68, 52, 50, 65, 48, 51, 48, 49, 52, 51, 49, 48, 53, 48, 48, 48, 48, 48, 51, 57, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 52, 53, 48, 56, 48, 48, 48, 48, 52, 52, 48, 48, 53, 51, 48, 50, 48, 48, 53, 65, 48, 52, 48, 48, 48, 48, 53, 66, 48, 56, 48, 49, 49, 52, 48, 48, 48, 48, 53, 67, 48, 50, 70, 70, 53, 69, 48, 50, 70, 70, 49, 53, 48, 56, 48, 48, 48, 48, 48, 49, 65, 52, 49, 56, 48, 56, 48, 48, 48, 48, 48, 65, 67, 56, 52, 51, 48, 51, 48, 48, 48, 53, 70, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 53, 54, 48, 50, 48, 48, 53, 55, 48, 50, 48, 48, 53, 53, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 54, 49, 48, 56, 48, 48, 48, 53, 50, 48, 49, 67, 54, 50, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 53, 52, 48, 50, 48, 48, 54, 51, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 54, 52, 48, 52, 48, 48, 48, 48, 54, 53, 48, 52, 48, 48, 48, 48, 48, 50, 48, 49, 56, 70, 48, 48, 48, 52, 49, 48, 48, 48, 56, 51, 48, 66, 49, 53, 55, 50, 52, 57, 55, 50, 56, 52, 50, 51, 53, 48, 56, 48, 48, 48, 67, 48, 48, 48, 49, 48, 57, 49, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 50, 48, 49, 48, 49, 51, 48, 49, 49, 49, 52, 48, 49, 48, 48, 51, 48, 57, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 52, 48, 57, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 53, 48, 53, 48, 48, 48, 48, 48, 51, 51, 48, 52, 48, 48, 48, 48, 48, 54, 48, 52, 48, 48, 48, 48, 48, 49, 48, 67, 49, 55, 49, 49, 50, 56, 48, 54, 48, 55, 51, 49, 49, 48, 48, 56, 53, 65, 49, 67, 56, 67, 65, 51, 49, 69, 48, 56, 48, 50, 54, 53, 51, 68, 68, 56, 51, 54, 48, 53, 48, 48, 48, 48, 48, 48, 55, 48, 50, 48, 48, 55, 68, 48, 52, 48, 48, 48, 48, 49, 50, 48, 56, 48, 48, 48, 48, 48, 50, 68, 52, 50, 65, 48, 51, 48, 49, 52, 51, 49, 48, 53, 48, 48, 48, 48, 48, 51, 57, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 52, 53, 48, 56, 48, 48, 48, 48, 52, 52, 48, 48, 53, 51, 48, 50, 48, 48, 53, 65, 48, 52, 48, 48, 48, 48, 53, 66, 48, 56, 48, 49, 49, 52, 48, 48, 48, 48, 53, 67, 48, 50, 70, 70, 53, 69, 48, 50, 70, 70, 49, 53, 48, 56, 48, 48, 48, 48, 48, 49, 65, 52, 49, 56, 48, 56, 48, 48, 48, 48, 48, 65, 67, 56, 52, 51, 48, 51, 48, 48, 48, 53, 70, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 53, 54, 48, 50, 48, 48, 53, 55, 48, 50, 48, 48, 53, 53, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 54, 49, 48, 56, 48, 48, 48, 53, 50, 48, 49, 67, 54, 50, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 53, 52, 48, 50, 48, 48, 54, 51, 48, 56, 48, 48, 48, 48, 48, 48, 48, 48, 54, 52, 48, 52, 48, 48, 48, 48, 54, 53, 48, 52, 48, 48, 48, 48};
        System.out.println(bytes1.length);
        String s2 = new String("1");
        byte[] bytes2 = s2.getBytes();
        System.out.println(Arrays.toString(bytes2));
        byte[] bytes3 = {127};
        String s3 = bytes3.toString();
        System.out.println(s3);
    }
}