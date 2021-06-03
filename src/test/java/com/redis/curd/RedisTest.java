package com.redis.curd;

import com.Serializable.SerializeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.redis.RedisCacheBuilder;
import com.alicp.jetcache.support.FastjsonKeyConvertor;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import com.design.demo.domain.Car;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/9/14 17:40
 * @Modified by:
 */

public class RedisTest {


    @Test
    public void test() {
        Jedis jedis = new Jedis("148.70.213.66", 6379);

        String ping = jedis.ping();
        System.out.println(ping);

        //redis支持五种类型

        //String   可以用来存储jsonObject 取到之后反序列化


        //hash结构  Object


        //list结构


        //Set结构(去重集合)

        //zset(sorted set：有序去重集合)


        //==============开始=================
        //hash结构  Object

        Set<String> keys = jedis.keys("*");

        keys.stream().peek(v -> System.out.println(v)).collect(Collectors.toList());


        jedis.hset("hashStudent", "id", "1");
        jedis.hset("hashStudent", "name", "zs");
        jedis.hset("hashStudent", "age", "18");
        jedis.hset("hashStudent", "height", "160");

        Map<String, String> map = jedis.hgetAll("hashStudent");


        Map map1 = new HashMap();
        map1.put("name", "nice");
        jedis.hmset("map", map1);
        System.out.println(jedis.hkeys("map"));
        System.out.println(jedis.hmget("map", "name"));
    }


    /**
     * redis 存储list<Object>
     */
    @Test
    public void testJson() {


        List<Car> cars = Arrays.asList(
                Car.builder().id(1L).model("宝马").make("中国").build(),
                Car.builder().id(1L).model("奔驰").make("中国").build(),
                Car.builder().id(1L).model("别克").make("中国").build(),
                Car.builder().id(1L).model("现代").make("中国").build()
        );

        Jedis jedis = new Jedis("148.70.213.66", 6379);

        String s = JSONObject.toJSONString(cars);
        System.out.println(s);
        jedis.set("carList", s);

        String carList = jedis.get("carList");

        System.out.println(carList);


        List<Car> list = JSONObject.parseArray(carList, Car.class);

        list.stream().peek(v -> System.out.println(v.toString())).collect(Collectors.toList());


    }

    /**
     * redis 存储list<Object>
     */
    @Test
    public void testJeCache() {


        Jedis jedis = new Jedis("148.70.213.66", 6379);

        String s = jedis.get("test::1");

        Object parse = JSONObject.parse(s);

        System.out.println(s);


    }


    /**
     * 使用 jetCache 存储Object
     */
    @Test
    public void testJetCache() {
        GenericObjectPoolConfig pc = new GenericObjectPoolConfig();
        pc.setMinIdle(2);
        pc.setMaxIdle(10);
        pc.setMaxTotal(10);
        JedisPool pool = new JedisPool(pc, "148.70.213.66", 6379);
        Cache<Long, Car> carCache = RedisCacheBuilder.createRedisCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .valueEncoder(JavaValueEncoder.INSTANCE)
                .valueDecoder(JavaValueDecoder.INSTANCE)
                .jedisPool(pool)
                .keyPrefix("carCache-")
//                .expireAfterWrite(200, TimeUnit.SECONDS)
                .buildCache();
        carCache.put(1L, Car.builder().id(1L).model("BM").make("CN").build());

    }

    /**
     * 使用jetCache 提取
     */

    @Test
    public void testJetCacheGet() {
        GenericObjectPoolConfig pc = new GenericObjectPoolConfig();
        pc.setMinIdle(2);
        pc.setMaxIdle(10);
        pc.setMaxTotal(10);
        JedisPool pool = new JedisPool(pc, "148.70.213.66", 6379);
        Cache<Long, Car> carCache = RedisCacheBuilder.createRedisCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .valueEncoder(JavaValueEncoder.INSTANCE)
                .valueDecoder(JavaValueDecoder.INSTANCE)
                .jedisPool(pool)
                .keyPrefix("carCache-")
//                .expireAfterWrite(200, TimeUnit.SECONDS)
                .buildCache();
        Car car = carCache.get(1L);
        System.out.println(car.toString());
    }


    /**
     * TODO  有问题,无法反序列化 还是对jetcache的写入方式不了解
     *
     * 使用 SerializeUtil提取
     */
    @Test
    public void SerializeRedisTest(){

        Jedis jedis = new Jedis("148.70.213.66", 6379);

        String carCache = jedis.get("carCache-1");
        System.out.println(carCache);

        Object car = SerializeUtil.unserialize(carCache.getBytes());
        System.out.println(car.toString());
    }
}
