package com.example.zipkinconsumer2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Title:com.example.zipkinconsumer2.controller
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/05  17:21
 */
@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping(value = "/consumer-2")
    public String trace(){
        log.info("==========call consumer-1==========");
        //return restTemplate().getForObject("http://127.0.0.1:8080/consumer-1",String.class);
        return "Trace";
    }
}
