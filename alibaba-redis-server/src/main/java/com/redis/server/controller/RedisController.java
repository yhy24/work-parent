package com.redis.server.controller;

import com.redis.server.util.IdGneraterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/get")
    public String getRedis() {
        IdGneraterUtil id = new IdGneraterUtil(redisTemplate);
        if (null == redisTemplate) {
            System.out.println("redisTemplate为空");
        } else {
            System.out.println("redisTemplate不为空" + redisTemplate.getConnectionFactory());
            redisTemplate.opsForValue().set("yang", "hao");
        }
        String StrId = id.generateOrderId();
        System.out.println(StrId);
        return "测试redis"+StrId;
    }
}
