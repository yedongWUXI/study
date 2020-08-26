package com.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangyedong
 * @date 2018/7/3.
 */
public class StreamTest {
    @Test
    public void test() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 800, Dish.Type.OTHER),
                new Dish("french", false, 800, Dish.Type.OTHER),
                new Dish("rice", true, 800, Dish.Type.OTHER),
                new Dish("season", true, 800, Dish.Type.OTHER),
                new Dish("pizza", true, 800, Dish.Type.OTHER),
                new Dish("prawns", false, 1800, Dish.Type.FISH),
                new Dish("prawns", false, 1800, Dish.Type.FISH),
                new Dish("salmon", false, 800, Dish.Type.FISH)
        );


        List<Person> peopleList = Arrays.asList(
                new Person("pork", 1, "zs")
//                ,
//                new Person("beef", 2, "ls"),
//                new Person("chicken", 3, "ww"),
//                new Person("french", 4, "zl"),
//                new Person("rice", 5, "qg"),
//                new Person("season", 6, "wyx")
        );


        String string = Arrays.toString(menu.stream().filter(p -> p.getCalories() > 1000).collect(Collectors.toList()).toArray());
        System.out.println(string);

        Map<String, Dish> dishMap = menu.stream().collect(Collectors.toMap(Dish::getName, v -> v, (v1, v2) -> v1));


        List<Person> collect = peopleList.stream().filter(p -> dishMap.containsKey(p.getDishName())).collect(Collectors.toList());

        System.out.println(Arrays.toString(collect.toArray()));
        //peek里 用{}设置多个属性
        List<Person> collect1 = peopleList.stream().peek(v -> {
            v.setDishCalories(dishMap.get(v.getDishName()).getCalories());
            v.setName("");
        }).collect(Collectors.toList());


        System.out.println(collect1);

//        System.out.println(dishMap);


    }

}
