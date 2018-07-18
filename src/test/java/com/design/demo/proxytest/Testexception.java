package com.design.demo.proxytest;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by zhangyedong on 2017/12/2.
 */
public class Testexception implements Serializable{
    private static final long serialVersionUID = 3391145391506192583L;

    public static void main(String[] args) throws Exception {

        try {
            int[] a = {1,2,3};
            for(int i = 0 ;i < a.length+2;i++){
                System.out.println(a[i]);
            }

        }catch (Exception e){
            throw new IOException("ssssss");
        }finally {
            System.out.println("finally");
        }
    }
}
