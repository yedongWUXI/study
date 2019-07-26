package com.redis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/5/9 12:31
 * @Modified by:
 */

public class TestPing {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("139.224.14.200", 6379);

        jedis.set("test", "yedong");
        String test = jedis.get("test");

//        jedis.setrange()


        System.out.println(jedis.ping());
        System.out.println(test);


    }

    @Test
    public void test() {
        Assert.assertEquals(1, 1);
    }


    /**
     * init  RedisScript.  lua  ----just copy
     *
     * @return
     */
//    @Bean
    public RedisScript redisScript() {
        DefaultRedisScript redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/META-INF/scripts/request_rate_limiter.lua")));
        redisScript.setResultType(List.class);
        return redisScript;
    }

}
