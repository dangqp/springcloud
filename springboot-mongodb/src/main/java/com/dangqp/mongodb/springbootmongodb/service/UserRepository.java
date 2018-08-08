package com.dangqp.mongodb.springbootmongodb.service;

import com.dangqp.mongodb.springbootmongodb.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {

	Users findUserByName(String name);

	void removeUser(String name);

	void updateUser(String name, String key, String value);

}
