package com.example.demo.enumtest;

/**
 * Created by zhangyedong on 2018/1/10.
 */
public final class Season {

    public static Season[] values() {
        return (Season[]) $VALUES.clone();
    }


    private Season(String s, int i) {
    }

    public static final Season SPRING;
    public static final Season SUMMER;
    public static final Season AUTUMN;
    public static final Season WINTER;
    private static final Season $VALUES[];

    static {
        SPRING = new Season("SPRING", 0);
        SUMMER = new Season("SUMMER", 1);
        AUTUMN = new Season("AUTUMN", 2);
        WINTER = new Season("WINTER", 3);
        $VALUES = (new Season[]{
                SPRING, SUMMER, AUTUMN, WINTER
        });
    }
}
