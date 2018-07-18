package com.design.demo.Observe_designmodle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyedong on 2018/1/2.
 */
public class Teacher implements Subject {
    List<Observe> list = new ArrayList<Observe>();
    @Override
    public void attach(Observe observe) {
        list.add(observe);

    }

    @Override
    public void detach(Observe observe) {
        list.remove(observe);

    }

    @Override
    public void notify(String message) {
        if("老师来了".equals(message)){

            for (Observe o : list
                    ) {
                o.update();

            }
        }

    }
}
