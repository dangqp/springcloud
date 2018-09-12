package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy //默认开启
public class SpringbootAopLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopLogApplication.class, args);
	}
}
