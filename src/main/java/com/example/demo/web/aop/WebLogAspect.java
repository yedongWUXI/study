package com.example.demo.web.aop;

import com.example.demo.web.OperationLog;
import com.example.demo.web.UserOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author zhangyedong
 * @date 2018/2/7.
 */

//切面类
/*
 * 特别注意： Spring的配置文件中添加：
 *
 * <aop:aspectj-autoproxy />
 * spring-mvc-dispatcher.xml中天机
 * <!--通知spring使用cglib而不是jdk的来生成代理方法 AOP可以拦截到Controller-->
 * <aop:aspectj-autoproxy proxy-target-class="true"/>
 *
 * <aop:config>节点中proxy-target-class="true"不为true时。
 * 当登录的时候会报这个异常java.lang.NoSuchMethodException: $Proxy54.login()，
 */


@Aspect
@Component
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    @Pointcut("@annotation(com.example.demo.web.OperationLog)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(){
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void after(JoinPoint joinPoint,Object ret){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String remoteAddr = request.getRemoteAddr();
        UserOperation userOperation = this.getInfo(joinPoint);
        userOperation.setClientIp(remoteAddr);

        userOperation.setExeTime(System.currentTimeMillis()-startTime.get());
        System.out.println(userOperation.getClientIp());
        System.out.println(userOperation.getModule());
        System.out.println(userOperation.getMenu());
        System.out.println(userOperation.getOperation());
        System.out.println(userOperation.getMethod());
        System.out.println(userOperation.getExeTime());


    }

    public UserOperation getInfo(JoinPoint joinPoint){
        UserOperation userOperation = new UserOperation();
        Class<?> clazz = joinPoint.getTarget().getClass();
        String name = joinPoint.getSignature().getName();
        userOperation.setMethod(joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //参数
        Object[] parameterTypes = joinPoint.getArgs();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(name)
                    && method.getParameterTypes().length == parameterTypes.length) {
                OperationLog annotation = method.getAnnotation(OperationLog.class);
                if(annotation!=null){
                    userOperation.setModule(annotation.module());
                    userOperation.setMenu(annotation.menu());
                    userOperation.setOperation(annotation.operation());
                }
            }
        }
        return userOperation;
    }



}

