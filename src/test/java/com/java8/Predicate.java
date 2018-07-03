package com.java8;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/6/20 14:34
 * @Modified by:
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

}
