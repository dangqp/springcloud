package com.example.zipknserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer //http方式收集用
@EnableZipkinStreamServer//用消息代理收集
public class ZipknServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipknServerApplication.class, args);
    }
}
