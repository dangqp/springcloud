package com.example.springboot_customer.service;

import com.example.springboot_customer.domain.Book;
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
    public void findAll() throws Exception {
        List<Book> all = bookService.findAll();
        System.out.println(all.toString());
    }

    @Test
    public void findOne(){
        Book one = bookService.findOne(1001L);
        System.out.println(one.toString());
    }

    @Test
    public void testUpdBatch1(){
        List<Integer> integers = bookService.updateBatch2();
        System.out.println(integers);
    }
}