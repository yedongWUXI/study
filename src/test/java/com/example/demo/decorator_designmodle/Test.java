package com.example.demo.decorator_designmodle;

/**
 * @author zhangyedong
 * @date 2018/3/5.
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        House house = new BedRoom();
        Decorator decorator = new PersonThree(new PersonTwo(new PersonOne(house)));

//        Decorator personOne = new PersonOne(house);
//        Decorator personTwo = new PersonTwo(personOne);
//        Decorator personThree = new PersonThree(personTwo);
//        personThree.paint();
//        personThree.wallpaper();


        decorator.paint();
        decorator.wallpaper();
    }
}
