package com.java.demo.io;

import java.io.*;
import java.net.URL;

/**
 * Created by zhangyedong on 2017/12/4.
 */
public class Test {

    @org.junit.Test
    public void test() {

        File classFile = getClassFile(Test.class);
        String string = classFile.toString();
        System.out.println(string);
        System.out.println(Test.class.getName());
//        try {
//            InputStream is = new FileInputStream("");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 以byte的形式读取 hello.txt
     */
    @org.junit.Test
    public void test1() {

        File file = new File("/Users/zhangyedong/IdeaProjects/demo-spring-boot" + "/" + "hello.txt");
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] data = new byte[in.available()];
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

    /**
     * @param clazz
     * @return class的File属性
     */
    public static File getClassFile(Class clazz) {
        URL path = clazz.getResource(clazz.getName().substring(
                clazz.getName().lastIndexOf(".") + 1)
                + ".class");

        String substring = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
        System.out.println(substring);

        if (path == null) {
            // replaceAll 传入的是个正则参数，所以需要[]
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }
        return new File(path.getFile());
    }

    @org.junit.Test
    public void test2(){
        String name = Test.class.getName();
        String substring = name.substring(Test.class.getName().lastIndexOf(".")+1);
        URL resource = Test.class.getResource("Student.class");
        String file = resource.getFile();
        System.out.println(file);
        System.out.println(substring);
        System.out.println(resource.toString());
        System.out.println(Test.class.getName().replaceAll("[.]","/"));
    }

}
