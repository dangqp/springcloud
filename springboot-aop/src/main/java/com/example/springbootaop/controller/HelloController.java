package com.example.springbootaop.controller;

import com.example.springbootaop.domain.ResultVO;
import com.example.springbootaop.service.HelloServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:com.example.springbootaop.controller
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/10/12  15:43
 */
@RestController
public class HelloController {

    @Autowired
    HelloServiceImple helloServiceImple;

    @GetMapping("/get")
    public ResultVO get(){
        return helloServiceImple.get();
    }

}
