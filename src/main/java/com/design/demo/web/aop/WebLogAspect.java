package com.design.demo.web.aop;

import com.alibaba.fastjson.JSONObject;
import com.design.demo.web.OperationLog;
import com.design.demo.web.UserOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

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

    public static JSONObject jsonpObject = new JSONObject();

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.design.demo.web.OperationLog)")
//    @Pointcut("execution(com.design.demo.controller.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 原则是 ：切点的一切操作都要tryCatch住，不能影响主程序的进行
     *
     * @param joinPoint
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void after(JoinPoint joinPoint, Object ret) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String remoteAddr = request.getRemoteAddr();
        UserOperation userOperation = this.getInfo(joinPoint);
        userOperation.setClientIp(remoteAddr);

        userOperation.setExeTime(System.currentTimeMillis() - startTime.get());
        System.out.println(userOperation.getClientIp());
        System.out.println(userOperation.getModule());
        System.out.println(userOperation.getMenu());
        System.out.println(userOperation.getOperation());
        System.out.println(userOperation.getMethod());
        System.out.println(userOperation.getExeTime());


        try {
            if (!Objects.isNull(joinPoint)) {

                String params = bulidParams(joinPoint) + " ";
                System.out.println("aop get params = " + params);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }


    }

    public UserOperation getInfo(JoinPoint joinPoint) {
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
                if (annotation != null) {
                    userOperation.setModule(annotation.module());
                    userOperation.setMenu(annotation.menu());
                    userOperation.setOperation(annotation.operation());
                }
            }
        }
        return userOperation;
    }


    /**
     * 获取方法参数名及对应值
     */
    private String bulidParams(JoinPoint joinPoint) {
        String[] paramNames = getParamNames(joinPoint);
        Object[] args = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String methodName = joinPoint.getSignature().getName();
        sb.append('"' + "methodName" + '"');
        sb.append(":").append('"').append(methodName).append('"').append(",");
        for (int k = 0; k < args.length; k++) {
            Object arg = args[k];
            if (arg == null) {
                continue;
            }
            sb.append('"' + paramNames[k] + '"');
            sb.append(":").append(argValue(arg)).append(",");

        }
        sb.append("}");
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        return sb.toString();
    }

    /**
     * 获取参数名称
     *
     * @param joinPoint
     * @return
     */
    private String[] getParamNames(JoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getParameterNames();
    }

    private static String argValue(Object arg) {
        String argStr = jsonpObject.toJSONString(arg);
        return argStr;
    }


}

