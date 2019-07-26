package com.java8;

import com.design.demo.domain.Car1;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/6/12 17:05
 * @Modified by:
 */

public class Stream {

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        updateAll();
        Thread t = new Thread(() -> {
            Object obj = new Object();
            while (true) {
                synchronized (obj) {
                    try {
                        obj.wait(1000);
                    } catch (InterruptedException e) {
                    }
                }
                updateAll();
            }
        });
        t.start();
    }


    public static void updateAll() {
        System.out.println("updateAll");
    }


    @Test
    public void test() {

        // 1. Individual values
        java.util.stream.Stream stream = java.util.stream.Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = java.util.stream.Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.stream().filter((String string) -> string.isEmpty()).count();
        System.out.println(count);

        long count1 = strings.stream().filter(String::isEmpty).count();
        System.out.println(count1);


        int[] ints = {1, 2, 3};
        String a = "2", b = "3";

        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(1);
        listInteger.add(1);
        listInteger.add(10);
        listInteger.add(11);
        boolean b1 = listInteger.stream().anyMatch(integer -> integer > 10);
        boolean b2 = listInteger.parallelStream().anyMatch(integer -> integer > 10);
        boolean equals = listInteger.stream().filter(integer -> integer > 10).findAny().equals(1);
        List<Integer> collect = listInteger.stream().filter(integer -> integer > 10).filter(integer -> integer <= 11).collect(Collectors.toList());
        List<Integer> collect1 = listInteger.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> collect2 = listInteger.stream().distinct().collect(Collectors.toList());
        List<Integer> collect3 = listInteger.stream().limit(2).collect(Collectors.toList());
        List<Integer> collect4 = listInteger.stream().filter(integer -> integer > 10).peek(e -> System.out.println("filter value" + e)).collect(Collectors.toList());

        System.out.println("排序" + Arrays.toString(collect1.toArray()));
        System.out.println("去重" + Arrays.toString(collect2.toArray()));

        System.out.println("过滤" + Arrays.toString(collect.toArray()));
        System.out.println("截取" + Arrays.toString(collect3.toArray()));
        System.out.println("截取" + Arrays.toString(collect4.toArray()));
        Integer reduce = listInteger.stream().reduce(0, (sum, item) -> sum + item);
        System.out.println("reduce" + reduce);
        System.out.println(equals);
        System.out.println(b1);
        System.out.println(b2);

        Collection listArray = new ArrayList();
        Collection set = new HashSet();

    }

    @Test
    public void test3() throws InterruptedException {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers =
                new ArrayList<>(Arrays.asList(intArray));
        List<Integer> parallelStorage = new ArrayList<>();//Collections.synchronizedList(new ArrayList<>());
        listOfIntegers
                .parallelStream()
                // Don't do this! It uses a stateful lambda expression.
                .map(e -> {
                    parallelStorage.add(e);
                    return e;
                })
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Sleep 5 sec");
        TimeUnit.SECONDS.sleep(5);
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
    }


    @Test
    public void test4() {
        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(1);
        listInteger.add(1);
        listInteger.add(10);
        listInteger.add(11);
        listInteger.stream().forEach(s -> System.out.println("1111"));
        System.out.println(Arrays.toString(listInteger.toArray()));


        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);


        /**
         * 简化版
         */
        List<Integer> numsWithoutNullSimple = nums.stream().filter(num -> num != null).collect(Collectors.toList());


        /**
         * 还原版
         */
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).

                collect(() -> new ArrayList<Integer>(),

                        (list, item) -> list.add(item),

                        (list1, list2) -> list1.addAll(list2));

        System.out.println(Arrays.toString(numsWithoutNull.toArray()));
    }


    @Test
    public void test5() {
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date(2018, 5, 23, 19, 23);
        calendar.setTime(trialTime);

        // print out a bunch of interesting things
        System.out.println("ERA: " + calendar.get(Calendar.ERA));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: "
                + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: "
                + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
        System.out.println("DST_OFFSET: "
                + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));

        System.out.println("Current Time, with hour reset to 3");
        calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
        calendar.set(Calendar.HOUR, 3);
        System.out.println("ERA: " + calendar.get(Calendar.ERA));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: "
                + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: "
                + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000))); // in hours
        System.out.println("DST_OFFSET: "
                + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000))); // in hours
    }

    /**
     * MISS TIME TOBE CONTINUE
     */
    @Test
    public void test6() {

        String time = "2018/09/21/19";//获取制定日期时间戳
        String timeMarry = "2018/09/22/10";//获取制定日期时间戳
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd/hh").parse(time);
            long Timestamp = date.getTime();
            date = new SimpleDateFormat("yyyy/MM/dd/hh").parse(timeMarry);
//            long missTime = System.currentTimeMillis() - Timestamp;
            long missTime = date.getTime() - Timestamp;
            System.out.println("missTime:" + missTime / 1000 / 60 / 60 / 24 + "\t 天数");
            System.out.println("missTime:" + missTime / 1000 / 60 / 60 + "\t 小时");
            System.out.println("missTime:" + missTime / 1000 / 60 + "\t 分钟");
            System.out.println("missTime:" + missTime / 1000 + "\t 秒");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test7() {

        int i = 8;
        switch (i) {
            case 1:
                System.out.println("11111");
                break;
            case 2:
                System.out.println("22222");
            case 3:
                System.out.println("33333");
            case 4:
                System.out.println("44444");
            case 5:
                System.out.println("55555");
            case 6:
                System.out.println("66666");
                break;
        }
    }


    @Test
    public void test8() {

        String downlinkToCPMessageKey = "";

        List<String> keyList = Arrays.asList(downlinkToCPMessageKey.split(","));

        String s = Arrays.toString(keyList.toArray());
        System.out.println(s);


        Supplier<String> supplier = () -> "yedong";
        String s1 = supplier.get();
        System.out.println(s1);
    }


    @Test
    public void test9() {
        String timeStamp = "20180529180805";
        String substring = timeStamp.substring(8, 14);
        System.out.println(substring);
    }

    @Test
    public void test10() {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - 5 * 60 * 1000);
    }

    @Test
    public void test11() {
        List<Car1> list = new ArrayList();
        List<Long> collect = list.stream().map(Car1::getId).collect(Collectors.toList());


//        .collect(Collectors.toMap(UserBo::getUserId, v -> v, (v1, v2) -> v1));
//        第一个参数UserBo::getUserId 表示选择UserBo的getUserId作为map的key值；
//        第二个参数v -> v表示选择将原来的对象作为map的value值；
//        第三个参数(v1, v2) -> v1中，如果v1与v2的key值相同，选择v1作为那个key所对应的value值。
        Map<Long, Car1> collect1 = list.stream().collect(Collectors.toMap(Car1::getId, v -> v, (v1, v2) -> v1));


    }

}
