package com.example.demo.stringpractice;

import java.net.URL;

/**
 * Created by zhangyedong on 2017/12/9.
 */
public class TestJavaPath {
    /**
     * user.dir     获取程序当前路径
     * 测试获取class路径
     */
    @org.junit.Test
    public void test1(){
        String st = System.getProperty("user.dir");
        System.out.println(st);
        //获取class的相对路径
        String aPackage = TestJavaPath.class.getPackage().getName()+"."+TestJavaPath.class.getName()+"."+"class";
        System.out.println(aPackage);

        URL resource = TestJavaPath.class.getResource("");
        System.out.println(resource.toString());
        URL resource1 = TestJavaPath.class.getResource("/");
        System.out.println(resource1.toString());


    }
    /**
     * java.version          Java 运行时环境版本
     * java.vendor           Java 运行时环境版本
     * java.vendor.url       Java 供应商的 URL
     * java.vm.specification.version    Java 虚拟机规范版本
     * java.vm.specification.vendor         Java 虚拟机规范供应商 
     * java.vm.specification.name         Java 虚拟机规范名称 
     * java.vm.version         Java 虚拟机实现版本
     * java.vm.vendor           Java 虚拟机实现供应商
     * java.vm.name         Java 虚拟机实现名称
     * java.specification.version         Java 运行时环境规范版本
     * java.specification.vendor         Java 运行时环境规范供应商
     * java.specification.name         Java 运行时环境规范名称
     * os.name         操作系统的名称 
     * os.arch         操作系统的架构
     * os.version         操作系统的版本
     *
     *
     */
    @org.junit.Test
    public void test2(){
        System.out.println("java.version"+"====="+ System.getProperty("java.version"));
        System.out.println("java.vendor"+"====="+ System.getProperty("java.vendor"));
        System.out.println("java.vendor.url"+"====="+ System.getProperty("java.vendor.url"));
        System.out.println("java.vm.specification.version"+"====="+ System.getProperty("java.vm.specification.version"));
        System.out.println("java.vm.specification.vendor"+"====="+ System.getProperty("java.vm.specification.vendor"));
        System.out.println("java.vm.specification.name"+"====="+ System.getProperty("java.vm.specification.name"));
        System.out.println("java.vm.version"+"====="+ System.getProperty("java.vm.version"));
        System.out.println("java.vm.vendor"+"====="+ System.getProperty("java.vm.vendor"));
        System.out.println("java.vm.name"+"====="+ System.getProperty("java.vm.name"));
        System.out.println("java.specification.versoin"+"====="+ System.getProperty("java.specification.versoin"));
        System.out.println("java.specification.vendor"+"====="+ System.getProperty("java.specification.vendor"));
        System.out.println("java.specification.name"+"====="+ System.getProperty("java.specification.name"));
        System.out.println("os.name"+"====="+ System.getProperty("os.name"));
        System.out.println("os.arch"+"====="+ System.getProperty("os.arch"));
        System.out.println("os.version"+"====="+ System.getProperty("os.version"));
    }

    /**
     * "/"
     * ":"
     * "/n"
     */
    @org.junit.Test
    public void test3(){
        //  "/"
        System.out.println(System.getProperty("file.separator"));
        //  ":"
        System.out.println(System.getProperty("path.separator"));
        //  "/n"
        System.out.println(System.getProperty("line.separator"));
    }

    /**
     *	这些都没什么用...																												63. java.home         Java 安装目录 
     64. java.home         Java 安装目录 
     65. java.class.version         Java 类格式版本号 
     67. java.class.path         Java 类路径 
     69. java.library.path          加载库时搜索的路径列表 
     71. java.io.tmpdir         默认的临时文件路径 
     73. java.compiler         要使用的 JIT 编译器的名称 
     75. java.ext.dirs         一个或多个扩展目录的路径 
     77. user.name         用户的账户名称 
     78. user.home         用户的主目录
     */

    @org.junit.Test
    public void test4(){
        System.out.println("java.home"+"========"+System.getProperty("java.home"));
        System.out.println("java.class.path"+"========"+System.getProperty("java.class.path"));
        System.out.println("java.library.path"+"========"+System.getProperty("java.library.path"));
        System.out.println("java.io.tmpdir"+"========"+System.getProperty("java.io.tmpdir"));
        System.out.println("java.compiler"+"========"+System.getProperty("java.compiler"));
        System.out.println("java.ext.dirs"+"========"+System.getProperty("java.ext.dirs"));
        System.out.println("user.name"+"========"+System.getProperty("user.name"));
        System.out.println("user.home"+"========"+System.getProperty("user.home"));
    }
}
