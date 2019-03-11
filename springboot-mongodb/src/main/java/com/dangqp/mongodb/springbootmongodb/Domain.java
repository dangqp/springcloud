package com.dangqp.mongodb.springbootmongodb;

/**
 * Title:com.dangqp.mongodb.springbootmongodb
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/04  19:28
 */
public class Domain {

    String key;
    String str2;

    public Domain(String key, String str2) {
        this.key = key;
        this.str2 = str2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}
