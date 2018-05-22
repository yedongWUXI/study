package com.example.demo.serializabletest;

/**
 * Created by zhangyedong on 2017/12/21.
 */

//: Worm.java
// Demonstrates object serialization in Java 1.1

import java.io.Serializable;

class Data implements Serializable {
    private static final long serialVersionUID = 4689114946156500821L;
    private int i;

    Data(int x) {
        i = x;
    }

    public String toString() {
        return Integer.toString(i);
    }



}


