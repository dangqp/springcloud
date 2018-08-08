package com.example.springboot_customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class SpringbootCustomerApplication {

	@Autowired
	RedisTemplate redisTemplate;
	public void test(){
		ValueOperations valueOperations = redisTemplate.opsForValue();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCustomerApplication.class, args);
	}
}
