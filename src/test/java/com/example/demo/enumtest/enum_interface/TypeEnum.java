package com.example.demo.enumtest.enum_interface;

/**
 * Created by zhangyedong on 2017/12/19.
 *
 * 枚举实现接口，使用匿名内部类的方式
 */

public enum TypeEnum implements InterfaceTest{
    VIDEO(1, "视频") {
        @Override
        public double price(int x, double y) {
            return x+y;
        }

        @Override
        public void print() {
            System.out.println(this.name+this.value);
        }
    }, AUDIO(2, "音频") {
        @Override
        public double price(int x, double y) {
            return x+y;

        }

        @Override
        public void print() {
            System.out.println(this.name+this.value);

        }
    }, TEXT(3, "文本") {
        @Override
        public double price(int x, double y) {
            return x+y;
        }

        @Override
        public void print() {
            System.out.println(this.name+this.value);

        }
    }, IMAGE(4, "图像") {
        @Override
        public double price(int x, double y) {
            return x+y;
        }

        @Override
        public void print() {
            System.out.println(this.name+this.value);

        }
    };

    int value;
    String name;

    TypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        TypeEnum.AUDIO.print();
        double price = TypeEnum.AUDIO.price(5, 7);
        System.out.println(price);
    }
}

