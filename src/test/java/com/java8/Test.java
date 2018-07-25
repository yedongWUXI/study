package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/6/20 14:35
 * @Modified by:
 */

public class Test {

    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {//动态接收方法，就看传进来的是什么方法
                result.add(apple);
            }
        }
        return result;

    }


    public String getAppleColor(List<Apple> inventory,
                                PredicateTest<Apple> p) {
        for (Apple apple : inventory) {
            if ("red".equals(p.testString(apple)))
                return p.testString(apple);
        }
        return "";
    }

    /**
     * 初步测试方法的传递，java8新特性
     */
    @org.junit.Test
    public void test() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("green", 3));
        inventory.add(new Apple("red", 5));
        inventory.add(new Apple("yellow", 2));
        inventory.add(new Apple("blue", 4));
        //把Apple里的isGreenApple传递进去
        List<Apple> apples = filterApples(inventory, Apple::isGreenApple);
        System.out.println(Arrays.toString(apples.toArray()));
        //只用一次的方法无需专门定义，直接在lambda里写好
        List<Apple> lambdaApples = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(Arrays.toString(lambdaApples.toArray()));

        String appleColor = getAppleColor(inventory, (Apple a) -> a.getColor());
        System.out.println(appleColor);

        //使用Comparator里的comparing 传递行为
        Comparator<Apple> comparator = Comparator.comparing(Apple::getWeight);
        int compare = comparator.compare(new Apple("green", 5), new Apple("red", 6));
        System.out.println(compare);

        //使用list里的sort
        inventory.sort(comparator);
        inventory.sort(comparator.reversed());
        System.out.println(Arrays.toString(inventory.toArray()));
    }


    static Boolean testFunction(Function<Apple, Boolean> function, Apple apple) {

        return function.apply(apple);
    }


    @org.junit.Test
    public void test1() {


    }
}
