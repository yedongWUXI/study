package com.java.demo.enumtest.enumsingleton;

import com.java.demo.enumtest.enum_interface.TypeEnum;

/**
 * Created by zhangyedong on 2017/12/20.
 */
public class Test {
    @org.junit.Test
    public void test(){
        String name = TypeEnum.AUDIO.getName();
        System.out.println(name);
    }
    @org.junit.Test
    public void test1(){
        boolean b = DataSourceEnum.DATASOURCE.getConnection() == DataSourceEnum.DATASOURCE.getConnection();
        System.out.println(b);
    }
}
