package com.example.demo.stringpractice;

import org.junit.Test;

/**
 * Created by zhangyedong on 2017/12/14.
 */
public class StringBufferTest {
    @Test
    public void test(){
        StringBuilder sb = new StringBuilder(1);
        sb.append("ye");
        sb.append("dong");
        sb.append("dong");
        sb.append("dong");
        sb.append("dong");
        sb.append("dong");
        System.out.println(sb);
    }

    /**
     * 测试retrun this，this这种情况下相当于new StringBufferTest（）
     * @return
     */
    public  StringBufferTest getThis(){
        return this;
    }

    public static void main(String[] args) {
        try {

            StringBufferTest.class.newInstance().getThis().test();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
