package com.design.demo.Observe_designmodle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangyedong on 2017/12/31.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Observe {
    String name;

    @Override
    public void update() {
        System.out.println("赶紧安静上自习");
    }

}
