package com.example.springboot_eruka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbootErukaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootErukaApplication.class, args);
	}
}
