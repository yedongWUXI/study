package com.redis.queue;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2019/11/15 10:03
 * @Modified by:
 */

public class TestConsumer {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        while (true) {
            // 设置超时时间为0，表示无限期阻塞
            List<String> message = jedis.brpop(0, "test queue");
            System.out.println(message);
        }
    }

}
