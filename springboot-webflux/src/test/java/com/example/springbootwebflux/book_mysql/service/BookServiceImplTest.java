package com.example.springbootwebflux.book_mysql.service;

import com.example.springbootwebflux.book_mysql.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by T on 2018/8/11.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceImplTest {

    @Autowired
    BookServiceImpl bookService;
    @Test
    public void findAllBook() throws Exception {
        List<Book> allBook = bookService.findAllBook();
        System.out.println(allBook);
    }

}