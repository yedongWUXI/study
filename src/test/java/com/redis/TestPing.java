package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/5/9 12:31
 * @Modified by:
 */

public class TestPing {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("139.224.14.200", 6379);


        System.out.println(jedis.ping());


    }

}
