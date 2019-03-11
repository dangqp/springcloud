package com.example.springboot_customer.service;

import com.example.springboot_customer.domain.Book;
import com.example.springboot_customer.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Title:com.example.springboot_customer.service
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/11  18:37
 */
@Service
public class BookServiceImpl {

    @Autowired
    BookMapper bookMapper;

    public List<Book> findAll(){
        return bookMapper.selectBook();
    }

    public Book findOne(Long id){
        return bookMapper.selectBookById(id);
    }

    /**
     * 测试批量增加
     * @return
     */
    public List<Integer> updateBatch1(){
       List<Book> books  =  findAll();
        Book book = books.get(0);
        if(books.contains(book)){
            books.remove(0);
        }
        book.setName("123");
        book.setNumber(22);

        books.add(book);
        int i = bookMapper.updateBatch1(books);
        return Arrays.asList(i);
    }

    /**
     * 测试批量增加2
     * @return
     */
    public List<Integer> updateBatch2(){
        List<Book> books  =  findAll();
        Book book = books.get(0);
        if(books.contains(book)){
            books.remove(0);
        }
        book.setName("whoever");
        book.setNumber(22);

        books.add(book);
        int i = bookMapper.updateBatch1(books);
        return Arrays.asList(i);
    }
}
