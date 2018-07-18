package com.design.demo.web;

import java.lang.annotation.*;

/**
 * @author zhangyedong
 * @date 2018/2/8.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {
    String module() default "";
    String menu() default "";
    String operation() default "";
}
