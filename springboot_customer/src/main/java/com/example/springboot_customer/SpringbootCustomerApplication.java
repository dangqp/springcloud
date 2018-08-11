package com.example.springboot_customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot_customer.mapper")//扫描的包必须写java.lang.IllegalArgumentException: At least one base package must be specified
public class SpringbootCustomerApplication {

	/*@Autowired
	RedisTemplate redisTemplate;
	public void test(){
		ValueOperations valueOperations = redisTemplate.opsForValue();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCustomerApplication.class, args);
	}
}
