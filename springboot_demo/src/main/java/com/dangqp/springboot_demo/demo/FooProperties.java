package com.dangqp.springboot_demo.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Title:com.dangqp.springboot_demo.demo
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/04/29  11:23
 */
@ConfigurationProperties(prefix = "com.didispace")
public class FooProperties {
    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
