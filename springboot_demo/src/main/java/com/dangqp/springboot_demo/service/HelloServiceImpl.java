package com.dangqp.springboot_demo.service;

import org.springframework.stereotype.Service;

/**
 * Title:com.dangqp.springboot_demo.service
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/05/05  16:19
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "hello";
    }
}
