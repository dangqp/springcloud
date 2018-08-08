package com.dangqp.mongodb.springbootmongodb.service;


import com.dangqp.mongodb.springbootmongodb.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl implements IUserService {
	@Autowired
	MongoOperations mongoTemplate;

	@Autowired
	MongoTemplate mongoTemplate1;

	public void saveUser(Users users) {
		mongoTemplate.save(users);
	}

	public Users findUserByName(String name) {
		return mongoTemplate.findOne(
				new Query(Criteria.where("name").is(name)), Users.class);
	}

	public void removeUser(String name) {
		mongoTemplate.remove(new Query(Criteria.where("name").is(name)),
				Users.class);
	}

	public void updateUser(String name, String key, String value) {
		mongoTemplate.updateFirst(new Query(Criteria.where("name").is(name)),
				Update.update(key, value), Users.class);

	}

	public List<Users> listUser() {
		return mongoTemplate.findAll(Users.class);
	}

	@Override
	public List<Users> findAll() {
		List<Users> all = mongoTemplate1.findAll(Users.class);
		return all;
	}
}
