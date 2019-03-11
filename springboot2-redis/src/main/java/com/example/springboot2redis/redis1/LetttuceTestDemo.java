package com.example.springboot2redis.redis1;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.ExecutionException;

/**
 * Title:com.example.springboot2redis.redis1
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/10/10  15:47
 */
public class LetttuceTestDemo {


    @Test
    public void connectRedis() throws ExecutionException, InterruptedException {

        //create new client
        RedisClient rc = RedisClient.create("redis://127.0.0.1:6380/1");
        //create connector
        StatefulRedisConnection<String, String> connect = rc.connect();
        //sysc
        RedisCommands<String, String> sync = connect.sync();
        //async
        RedisAsyncCommands<String, String> async = connect.async();
        RedisFuture<String> future = async.set("dang", "6666");
        future.thenAccept((e) -> System.out.println(e)); // 接收到数据时 执行
        RedisFuture<String> dang = async.get("dang");
        System.out.println(dang.get());
        // 关闭连接
        connect.close();
        rc.shutdown();
//        RedisClusterClient.create()
    }
}
