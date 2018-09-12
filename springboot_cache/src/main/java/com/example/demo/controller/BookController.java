package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookExample;
import com.example.demo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title:com.example.demo.controller
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/01/25  18:24
 */

@RestController
public class BookController {

    @Autowired
    BookServiceImpl service;
    @RequestMapping("/get")
    public Book getBookByBookId(){
        Book book = new Book();
        book.setBookId(1000L);
        return service.getBookByBookId(book);
    }

    @RequestMapping("/update")
    public Book updateBybookId(){
        Book book = new Book();
        book.setName("JAVA基本教程22222");
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andBookIdEqualTo(1000L);
        Book updCnt = service.UpdateByBookId(book,example);
        return updCnt;
    }

    @RequestMapping("/update1")
    public Book updateBybookId1(){
        Book book = new Book();
        book.setName("everything i never tell");
        book.setBookId(1001L);
        Book updCnt = service.updateById(book);
        return updCnt;
    }

    @RequestMapping("/get1")
    public Book getBookById(){
        long bookId = 1001L;
        return service.getBookById(bookId);
    }

    @RequestMapping("/update2")
    public Book updateByBookId(){
        Book book = new Book();
        book.setNumber(40);
        book.setName("everything i never tell");
        book.setBookId(1001L);
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andBookIdEqualTo(1000L);
        return service.updateByBookId(book);
    }

    @RequestMapping("/del/{bookId}")
    public String delete(@PathVariable Long bookId){
        service.delete(bookId);
        return "ok";
    }

    @RequestMapping("/getAll")
    public List<Book> selectAll(){
        return service.selectAll();
    }
}
