package com.example.demo.enumtest;

import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangyedong on 2017/12/20.
 */
@NoArgsConstructor
@Transactional
public enum  FirstTimeTestEnum {
    TEST("1","zs"),TEST2("2","ls"),TEST3("3","ww"),TEST4("4","zl");
    String name;
    String value;
    public static final FirstTimeTestEnum TEST5 = null;
    static {
    }
    FirstTimeTestEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        /**
         * All the
         * constants of an enum type can be obtained by calling the
         * implicit {@code public static T[] values()} method of that
         * type.
         * 每个枚举都有一个隐试的values方法，用来返回枚举实例的数组
         */
        FirstTimeTestEnum[] values = FirstTimeTestEnum.values();
        for(int i = 0; i< values.length;i++){
            System.out.println(values[i].toString());
        }
        /**
         *
         * values()方法是编译器插入到enum定义中的static方法，所以，当你将enum实例向上转型为父类Enum是，
         * values()就不可访问了。解决办法：在Class中有一个getEnumConstants()方法
         */
        FirstTimeTestEnum[] enumConstants = FirstTimeTestEnum.class.getEnumConstants();
        for(int i = 0; i< enumConstants.length;i++){
            System.out.println(enumConstants[i].toString());
        }
    }
}
