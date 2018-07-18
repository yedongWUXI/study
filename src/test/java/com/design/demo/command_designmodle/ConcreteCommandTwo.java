package com.design.demo.command_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/27.
 */
public class ConcreteCommandTwo implements Command {
    Receiver receiver;

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ConcreteCommandTwo(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        this.receiver.doSomethingOne();
        this.receiver.doSomethingThree();
    }
}
