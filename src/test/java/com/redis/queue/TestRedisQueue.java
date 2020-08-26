package com.redis.queue;

import com.alibaba.fastjson.JSONObject;
import com.design.demo.json.Student;
import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2019/11/15 10:00
 * @Modified by:
 */

public class TestRedisQueue {
    public static void main(String[] args) {
        Student student = new Student("zs", 18);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 向键为“test queue”的值的左端推入数据
        for (int i = 0; i < 5; i++) {

            jedis.lpush("test queue", i + JSONObject.toJSONString(student));
        }

    }

}
