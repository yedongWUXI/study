package com.java.demo.io.urlio;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhangyedong
 * @date 2018/5/27.
 */
public class UrlIoTest {

    @Test
    public void test(){
        InputStream in = null;
        try {
            URL url = new URL("http://localhost:8004/one");
            URLConnection urlConnection = url.openConnection();
            in = urlConnection.getInputStream();
            byte[] bs = new byte[in.available()];
            in.read(bs);
            String x = new String(bs);
            System.out.println(x);
        } catch (IOException e) {
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
