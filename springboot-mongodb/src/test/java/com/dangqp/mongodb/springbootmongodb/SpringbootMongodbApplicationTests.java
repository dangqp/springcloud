package com.dangqp.mongodb.springbootmongodb;

import com.dangqp.mongodb.springbootmongodb.web.MongoDBService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbApplicationTests {

	@Autowired
	private MongoDBService mangoDBService;

	@Test
	public void testSave() {
		Domain domain = new Domain("666666", "dasdasdasda");
		mangoDBService.save(domain);
	}
	@Test
	public void testInsert() {
		Domain domain = new Domain("test1", "dasdasdasda");
		mangoDBService.save(domain);
	}
	@Test
	public void testFindOne() {

		Query query = new Query();
		query.addCriteria(Criteria.where("key").in("test1"));
		Domain domain = mangoDBService.findOne(Domain.class,    query);
		//System.out.println("domain---"+domain.getJsonStr());
	}
	@Test
	public void testFindList() {
		Query query = new Query();
		int currentPage = 1;
		int pageSize = 10;
		query.addCriteria(Criteria.where("key").in("test1"));
		//Page<Domain> pagination = mangoDBService.getPagination(Domain.class, query,  currentPage, pageSize);
		//System.out.println(pagination.getRecordTotal());
	}
	@Test
	public void testFindCount() {
		Query query = new Query();
		query.addCriteria(Criteria.where("key").in("test1"));
		long count = mangoDBService.findCount(Domain.class, query);
		System.out.println(count);

	}
	@Test
	public void testUpdate() {
		Query query = new Query();
		query.addCriteria(Criteria.where("key").is("666666"));
		Update update = new Update();
		update.set("key", "999999999999999999");
		int i = mangoDBService.update(query, update, Domain.class);
		System.out.println(i);
	}

}

