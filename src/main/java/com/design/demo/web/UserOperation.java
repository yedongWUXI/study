package com.design.demo.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyedong
 * @date 2018/2/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOperation {
    String name;
    String module;
    String menu;
    String operation;
    String clientIp;
    String host;
    String method;

    /*** 执行时间 */
    private Long exeTime;
}
