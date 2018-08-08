package com.dangqp.mongodb.springbootmongodb.service;

import com.dangqp.mongodb.springbootmongodb.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBOprServiceImplTest {
    @Autowired
    UserRepositoryImpl userRepository;

    @Test
    public void save(){
        Users user = new Users("1","jack",20);
        userRepository.saveUser(user);
    }

    @Test
    public void findAll(){
        List<Users> users = userRepository.findAll();
        users.stream().forEach(p-> System.out.println(p));
    }
}