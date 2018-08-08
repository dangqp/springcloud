package com.example.springbootwebflux;

import com.example.springbootwebflux.book_momgodb.service.impl.BookMServiceImpl;
import com.example.springbootwebflux.book_mysql.domain.Book;
import com.example.springbootwebflux.book_mysql.mapper.BookMapper;
import com.example.springbootwebflux.book_mysql.service.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebfluxApplicationTests {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	BookServiceImpl bookService;
	@Test
	public void contextLoads() {
		//List<Book> books = bookMapper.selectBook();
		Flux<Book> all = bookService.findAll();
		System.out.println(all.count().flux().next());
		System.out.println(all.next());
	}
	@Autowired
	BookMServiceImpl bookMService;
	@Test
	public void saveBook(){
		Mono<com.example.springbootwebflux.book_momgodb.domain.Book> save = bookMService.save();
		System.out.println(save);
	}

	@Test
	public void testFindByID(){
		Mono<com.example.springbootwebflux.book_momgodb.domain.Book> byBookId = bookMService.findByBookId(1L);
		System.out.println(byBookId.toString());
	}

	@Test
	public void testByName(){
		List<com.example.springbootwebflux.book_momgodb.domain.Book> byBookName = bookMService.findByBookName1("册");
		System.out.println(byBookName);

	}
}
