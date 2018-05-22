package com.example.demo.command_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/27.
 */
public class ConcreteCommand implements Command {
    Receiver receiver;

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        this.receiver.doSomethingThree();
    }
}
