package com.example.demo.decorator_designmodle.io;

import java.io.*;

/**
 * @author zhangyedong
 * @date 2018/3/6.
 */
public class Test {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            InputStream inputStream = in = new FileInputStream(new File(""));
            in.read();
            in.close();
        } catch (Exception e) {

        }


    }


    @org.junit.Test
    public void test() {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(new File("/mystudy/test/test.txt"))));
            System.out.println(in.read());
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void test2(){
        int c ;
        System.out.println((c=1) >0 );
    }
}
