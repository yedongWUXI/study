package com.java.demo.io;

import java.io.*;

/**
 * @author zhangyedong
 * @date 2018/2/6.
 * 读取文件夹下多个文件
 */
public class FilesTest {
    public static void main(String[] args) {
        File file = new File("/mystudy/test");
        File[] files = file.listFiles();
        InputStream in = null;
        for(int i = 0;i<files.length;i++){
            System.out.println(files[i].getName());
            String name = files[i].getName();
            File fileText = new File(name);
            try {
                in = new FileInputStream("/mystudy/test/"+fileText);
                byte[] data = new byte[1024];
                in.read(data);
                System.out.println(new String(data));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
