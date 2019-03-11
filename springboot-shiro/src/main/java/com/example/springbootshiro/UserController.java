package com.example.springbootshiro;

import com.example.springbootshiro.domain.User;
import com.example.springbootshiro.service.UserServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Title:com.example.springbootshiro
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/14  14:49
 */
@RestController
public class UserController {

    @Autowired
    UserServiceImple userServiceImple;

    @PostMapping("/save")
    public int register(@RequestParam User user){
        return userServiceImple.save(user);
    }

    @GetMapping("/get/{id}")
    public User getBy(@PathVariable String id){
        return userServiceImple.getBy(id);
    }
}
