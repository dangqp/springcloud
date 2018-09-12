package com.example.springbootdocker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:com.example.springbootdocker.controller
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/14  21:01
 */
@RestController
public class DockerController {
    @RequestMapping("/docker")
    public String index() {
        return "Hello Docker!";
    }
}
