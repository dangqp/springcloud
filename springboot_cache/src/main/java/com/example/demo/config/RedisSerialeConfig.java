package com.example.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * Title:com.example.demo.config
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/01/26  13:46
 */
@Configuration
public class RedisSerialeConfig extends CachingConfigurerSupport {

    /**
     * 自定义key. 这个可以不用
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        System.out.println("RedisCacheConfig.keyGenerator()");
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                // This will generate a unique key of the class name, the method name
                //and all method parameters appended.
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                System.out.println("keyGenerator=" + sb.toString());
                return sb.toString();
            }
        };
    }

    /**
     * RedisTemplate配置
     * 默认JdkSerializationRedisSerializer，导致乱码问题
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, ?> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        /**
         * 定义key序列化方式
         * Long类型会出现异常信息;需要我们上面的自定义key生成策略，一般没必要
         */
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        /**
         * 此处的key为Long类型，用此序列化工具类
         */
        RedisSerializer<Long> longRedisSerializers = new Jackson2JsonRedisSerializer<Long>(Long.class);
        /**
         * 定义value的序列化方式
         * GenericToStringSerializer：使用Spring转换服务进行序列化；
         * JacksonJsonRedisSerializer：使用Jackson 1，将对象序列化为JSON；
         * Jackson2JsonRedisSerializer：使用Jackson 2，将对象序列化为JSON；
         * JdkSerializationRedisSerializer：使用Java序列化；
         * OxmSerializer：使用Spring O/X映射的编排器和解排器（marshaler和unmarshaler）实现序列化，用于XML序列化；
         * StringRedisSerializer：序列化String类型的key和value。实际上是String和byte数组之间的转换
         */
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        /**
         * 将java对象转换为Jason对象
         */
        ObjectMapper om = new ObjectMapper();

        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        /**
         * 配置Redis
         */
        redisTemplate.setKeySerializer(longRedisSerializers);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
