package com.example.springbootwebflux.demo1.controller;

import com.example.springbootwebflux.demo1.handler.HelloWorldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Title:com.example.springbootwebflux.demo1.controller
 * Description: mvc
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/06  18:18
 */
@RestController
@RequestMapping("/hello")
public class HellloController {

    @Autowired
    HelloWorldHandler helloWorldHandler;

    @GetMapping("/hello")
    public Mono<String> hello(){
        return helloWorldHandler.hello();
    }
}
