package com.byte_hex;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Locale;

/**
 * @Description: String 和 byte hex 工具类
 * @Author: wxzhangyd
 * @Date: 2019/1/22 13:11
 * @Modified by:
 */

public class StringHelper {


    @Test
    public void test() {

        String s = "~�  \u0003\u0001�  (p \u000EB�\u0002�~";
        String s1 = binaryString2HexString(s, 4);
        System.out.println(s1);
    }


    /**
     * hex字符串，两两把值变成16进制的byte，放进byte[]
     *
     * @param src
     * @return
     */
    protected byte[] hexStr2Bytes(String src) {
        /*对输入值进行规范化整理*/
        src = src.trim().replace(" ", "").toUpperCase(Locale.US);
        //处理值初始化
        int m = 0, n = 0;
        int iLen = src.length() / 2; //计算长度
        byte[] ret = new byte[iLen]; //分配存储空间

        for (int i = 0; i < iLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = (byte) (Integer.decode("0x" + src.substring(i * 2, m) + src.substring(m, n)) & 0xFF);
        }
        return ret;
    }


    public static String binaryString2HexString(String byteString, int length) {
        if (StringUtils.isBlank(byteString)) {
            return "";
        } else {
            double byteLength = Math.ceil((double) byteString.length() / 4.0D);
            if (byteLength < (double) length) {
                byteLength = (double) length;
            }

            byteString = StringUtils.leftPad(byteString, (int) (byteLength * 4.0D), "0");
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < byteString.length(); i += 4) {
                int tmp = Integer.parseInt(byteString.substring(i, i + 4), 2);
                stringBuilder.append(Integer.toHexString(tmp));
            }

            return stringBuilder.toString();
        }
    }

    public static String hexString2BinaryString(String hexString) {
        if (StringUtils.isBlank(hexString)) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < hexString.length(); ++i) {
                stringBuilder.append(StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16)), 4, "0"));
            }

            return stringBuilder.toString();
        }
    }

    public static Integer hexString2Int(String hexString) {
        return Integer.valueOf(hexString, 16);
    }

    public static String byte2HexString(byte b, boolean padLeft) {
        return padLeft ? StringUtils.leftPad(Integer.toHexString(b), 2, "0") : Integer.toHexString(b);
    }

    public static String byte2BinaryString(byte b) {
        return "" + (byte) (b >> 7 & 1) + (byte) (b >> 6 & 1) + (byte) (b >> 5 & 1) + (byte) (b >> 4 & 1) + (byte) (b >> 3 & 1) + (byte) (b >> 2 & 1) + (byte) (b >> 1 & 1) + (byte) (b >> 0 & 1);
    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[]{(byte) (res & 255), (byte) (res >> 8 & 255), (byte) (res >> 16 & 255), (byte) (res >>> 24)};
        return targets;
    }

    public static int byte2int(byte[] res) {
        int targets = res[0] & 255 | res[1] << 8 & '\uff00' | res[2] << 24 >>> 8 | res[3] << 24;
        return targets;
    }


}
