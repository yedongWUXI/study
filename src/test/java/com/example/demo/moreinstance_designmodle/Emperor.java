package com.example.demo.moreinstance_designmodle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhangyedong
 * @date 2018/1/28.
 */
public class Emperor {
    private String name;
    private static final int MAXNUM = 5;
    private static List<String> emperorInfo = new ArrayList<>();
    private static List<Emperor> emperors = new ArrayList<>();
    private Emperor() {
    }


    private Emperor(String name) {
        this.name = name;
        emperorInfo.add(name);
    }

    static {
        for(int i = 0 ;i < MAXNUM; i ++){
            Emperor emperor = new Emperor("第" + i + "个皇帝");
            emperors.add(emperor);
        }
    }

    public String getName() {
        return name;
    }

    public static Emperor getInstance(){
        Random random = new Random();
        return emperors.get(random.nextInt(MAXNUM));
    }
}
