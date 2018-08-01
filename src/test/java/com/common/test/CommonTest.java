package com.common.test;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.AbstractProcessor;
import java.awt.image.DataBuffer;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 */
public class CommonTest {
    @Transactional
    public void test() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        for (int i = 0, n = args.length; i < n; i++) {
            System.out.println("Arg " + i + ":" + args[i]);
        }
        System.out.println(11);
        Type type = new Type() {
            @Override
            public String getTypeName() {
                return null;
            }
        };

        Class.forName("");
    }

    @Test
    public void test1() {
        AbstractProcessor abstractProcessor = null;
        BeanDefinition beanDefinition = null;
        BeanDefinitionRegistry beanDefinitionRegistry = null;
        ClassLoader classLoader = null;
        ArrayBlockingQueue arrayBlockingQueue = null;
        Condition condition = null;
        ConcurrentHashMap concurrentHashMap = null;
        Exchanger exchanger = null;
        DataBuffer dataBuffer = null;
        Callable callable = null;
        ThreadPoolExecutor threadPoolExecutor = null;
        SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();
        sortedMap.put(2,"2");
        sortedMap.put(1,"1");
        sortedMap.put(4,"4");
        sortedMap.put(3,"3");
        List<String> msgList = new ArrayList<>();
        msgList.add("1");
        msgList.add("1");
        msgList.add("1");
        msgList.add("2");
        List<String> collect = msgList.stream().distinct().collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));
    }
}
