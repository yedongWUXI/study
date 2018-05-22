package com.example.demo.CglibProxy;

import org.assertj.core.internal.cglib.proxy.Callback;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangyedong on 2017/12/5.
 */
public class MyProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object o1 = methodProxy.invokeSuper(o, objects);
        return o1;
    }

    public void test(Callback cb){
        System.out.println("test callback");
    }
}
