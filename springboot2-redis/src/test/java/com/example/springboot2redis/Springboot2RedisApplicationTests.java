package com.example.springboot2redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2RedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testRedisTemplete(){
        ValueOperations valueOperations = redisCacheTemplate.opsForValue();
        Object o = valueOperations.get("dang");
        System.out.println(o);
    }
}
