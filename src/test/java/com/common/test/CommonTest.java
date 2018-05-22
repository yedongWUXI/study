package com.common.test;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.AbstractProcessor;
import java.lang.reflect.Type;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 */
public class CommonTest {
    @Transactional
    public void test(){

    }

    public static void main(String[] args) throws ClassNotFoundException {
        for (int i=0, n=args.length; i<n; i++) {
            System.out.println("Arg " + i +":" + args[i]);
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
    public void test1(){
        AbstractProcessor abstractProcessor = null;
        BeanDefinition beanDefinition = null;
        BeanDefinitionRegistry beanDefinitionRegistry = null;
        ClassLoader classLoader = null;
    }
}
