package com.dangqp.springboot_demo.comtroller;

import com.dangqp.springboot_demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:com.dangqp.springboot_demo.comtroller
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/05/05  16:19
 */
@RestController
@RequestMapping("/get")
public class HelloController {
    @Autowired
    private HelloService service;

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public String getHello(){
        return service.hello();
    }
}
