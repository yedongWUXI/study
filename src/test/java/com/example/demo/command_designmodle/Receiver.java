package com.example.demo.command_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/27.
 * 接收者，真正执行命令的对象。任何类都可能成为一个接收者，只要它能够实现命令要求实现的相应功能。
 */
public class Receiver {

    public void doSomethingOne(){
        System.out.println("具体的做事（1）");
    }

    public void doSomethingTwo(){
        System.out.println("具体的做事（2）");
    }

    public void doSomethingThree(){
        System.out.println("具体的做事（3）");
    }
}
