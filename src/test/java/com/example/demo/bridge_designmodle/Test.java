package com.example.demo.bridge_designmodle;

/**
 * @author zhangyedong
 * @date 2018/1/25.
 *
 * 继承的优点有很多，可以把公共的方法或属性抽取，父类封装共性，子类实现特性，这是继承的基本功能，
 * 缺点有没有？有，强关联关系
 *
 * 对于比较明确不发生变化的，则通过继承来完成，若不能确定是否会发生变化的，那就认为是会发生变化，则通过桥梁模式来解决
 *
 */
public class Test {
    @org.junit.Test
    public void test(){
        MobilePhone iphone = new Iphone();
        iphone.setFunction(new AddressBook());
        iphone.useMobile();

        MobilePhone sumPhone = new SumPhone();
        sumPhone.setFunction(new PhoneGame());
        sumPhone.useMobile();

    }
}
