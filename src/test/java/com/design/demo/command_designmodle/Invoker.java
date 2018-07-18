package com.design.demo.command_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/27.
 */
public class Invoker {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Invoker(Command command) {
        this.command = command;
    }

    public Invoker() {
    }

    public void runCommand(){
        this.command.excute();
    }
}
