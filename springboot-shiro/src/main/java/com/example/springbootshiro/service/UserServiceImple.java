package com.example.springbootshiro.service;

import com.example.springbootshiro.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:com.example.springbootshiro.service
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/10  09:44
 */
public class UserServiceImple {
    private  static  final  Map<String, Object> users = new HashMap<>();
    /**
     * 保存一个用户
     * @param user
     * @return
     */
    public int save(User user){
        users.put(String.valueOf(user.getId()),user);
        return 1;
    }

    /**
     *获取用户
     */
    public User getBy(String id){
        User user = null;
        if(users.containsKey(id)) {
            user = (User) users.get(id);
        }
        return user;
    }
}

