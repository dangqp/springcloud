package com.example.springboot_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SpringbootConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigServerApplication.class, args);
	}
}
