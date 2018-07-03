package com.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description: Function package test
 * @Author: wxzhangyd
 * @Date: 2018/7/2 13:57
 * @Modified by:
 */

public class FunctionTest {
    @Test
    public void test() {
        //无参
        Supplier<Apple> supplier = Apple::new;
        Apple apple1 = supplier.get();

        //一个参数
        Function<String,Apple> function = Apple::new;
        Apple apple = function.apply("yellow");

        //两个参数
        BiFunction<String,Integer,Apple> biFunction = Apple::new;
        Apple apple2 = biFunction.apply("red", 50);

//        Comparator<Apple> comparator = Comparator.comparing()

    }
}
