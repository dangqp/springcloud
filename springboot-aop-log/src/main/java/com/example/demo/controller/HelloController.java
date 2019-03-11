package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:com.example.demo.controller
 * Description: 测试aop
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/18  14:57
 */
@RestController
//@EnableAspectJAutoProxy 默认开启
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String hello){
        return hello;
    }
}
