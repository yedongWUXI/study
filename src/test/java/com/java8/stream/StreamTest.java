package com.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
                new Dish("prawns", false, 800, Dish.Type.FISH),
                new Dish("salmon", false, 800, Dish.Type.FISH)
        );

        String string = Arrays.toString(menu.stream().filter(Dish::getVegetarian).collect(Collectors.toList()).toArray());
        System.out.println(string);

    }


}
