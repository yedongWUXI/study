package com.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/8/27 9:00
 * @Modified by:
 */

public class JwtTest {

    @Test
    public void test() throws UnsupportedEncodingException {

        String token = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis()))  //设置过期时间
                .withAudience("user1") //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256("111111"));  //使用HMAC算法，111111作为密钥加密


        System.out.println(token);


        JWT.decode(token).getAudience().stream().peek(v -> System.out.println(v)).collect(Collectors.toList());


    }


    @Test
    public void test1() {
        String token = JwtUtil.sign("1111", "zs", "11111");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(token);

        String uid = JwtUtil.get(token, "uid");
        String username = JwtUtil.get(token, "username");
        String secret = JwtUtil.get(token, "secret");


        System.out.println(uid);
        System.out.println(username);
        System.out.println(secret);


    }

}
