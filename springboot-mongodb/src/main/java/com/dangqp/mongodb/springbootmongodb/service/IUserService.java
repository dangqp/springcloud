package com.dangqp.mongodb.springbootmongodb.service;


import com.dangqp.mongodb.springbootmongodb.domain.Users;

import java.util.List;

public interface IUserService {

	void saveUser(Users users);

	Users findUserByName(String name);

	void removeUser(String name);

	void updateUser(String name, String key, String value);

	List<Users> listUser();

	List<Users> findAll();
}
