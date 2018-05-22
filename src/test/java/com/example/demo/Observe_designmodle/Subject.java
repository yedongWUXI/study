package com.example.demo.Observe_designmodle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyedong on 2017/12/31.
 */
public interface Subject {
    List<Observe> observeList = new ArrayList<Observe>();

    void attach(Observe observe);


    void detach(Observe observe);

    void notify(String message);

}
