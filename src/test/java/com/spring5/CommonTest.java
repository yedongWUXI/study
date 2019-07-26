package com.spring5;

import com.design.demo.domain.Car;
import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/7/5 16:08
 * @Modified by:
 */

public class CommonTest {

    @Test
    public void test() {
        Mono<Car> empty = Mono.empty();
        Mono<Car> filter = empty.filter(b -> b.getModel().equals(""));
        System.out.println(filter.toString());

        Disposable subscribe = Mono.empty().subscribe(System.out::println);
        subscribe.toString();

        Mono.just("foo").subscribe(System.out::print);

        Mono.just(new Car()).subscribe(System.out::print);

        List list = new ArrayList<>();


        List<Integer> collect = Flux.just(5, 10).toStream().collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }


    }


    @Test
    public void test1() {
        Flux.just("1", "2", "3").subscribe(System.out::println);

        Flux.fromArray(new String[]{"1", "2", "3"}).subscribe(System.out::println);

        Flux.fromStream(Arrays.asList(new String[]{"1", "2", "3"}).stream()).subscribe(System.out::println);

        Flux.fromIterable(Arrays.asList(new String[]{"1", "2", "3"})).subscribe(System.out::println);

        /**
         * 空的
         */

        Flux.empty().subscribe(System.out::println);

        /**
         * 创建一个循环
         */

        Flux.range(1, 10).subscribe(System.out::println);

        System.out.println("=============");

        Flux.interval(Duration.of(1000, ChronoUnit.HOURS)).subscribe(System.out::println);


    }


}
