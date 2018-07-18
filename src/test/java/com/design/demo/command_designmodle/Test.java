package com.design.demo.command_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/27.
 */
public class Test {
    @org.junit.Test
    public void test1(){
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);
        //创建Invoker，把命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.runCommand();
    }
}
