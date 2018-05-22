package com.example.demo.proxytest.jdkproxysource;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by zhangyedong on 2017/12/7.
 */
public class Test {


    @org.junit.Test
    public void name() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("===============before================");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("================after================");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return null;
    }


    @org.junit.Test
    public void test() {
        //获得字节码的测试方法
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy1", Car.class.getInterfaces());
        for (byte by : classFile
                ) {
            System.out.println(by);
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(System.getProperty("user.dir") + "\\$Proxy1.class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @org.junit.Test
    public void test3(){
        System.out.println(System.getProperty("user.dir") + "\\$Proxy1.class");
    }

}
