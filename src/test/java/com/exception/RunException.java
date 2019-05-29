package com.exception;

/**
 * @Description: String.format  %s代表Exception里后面信息的占位符
 * @Author: Administrator
 * @Date: 2019/3/13 22:25
 * @Modified by:
 */

public class RunException {

    static class People{
        String name;
        int age;

    }

    public void method(People people){
        throw new RuntimeException(String.format("%s,%s,%s,%s 不符合规范",people.getClass(),people.name,"xxx","aaa"));
    }


    public static void main(String[] args) {
        RunException runException = new RunException();
        People people = new People();
        people.name = "zs";
        people.age = 31;
        runException.method(people);
    }
}
