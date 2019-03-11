package com.example.springbootwebflux.book_momgodb.controller;

import com.example.springbootwebflux.book_momgodb.domain.Book;
import com.example.springbootwebflux.book_momgodb.service.impl.BookMServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Title:com.example.springbootwebflux.book_momgodb.controller
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/08  13:15
 */
@RestController
public class BookMController {

    @Autowired
    BookMServiceImpl bookMService;

    @GetMapping("/findAll")
    public Flux<Book> findAll(){
        return bookMService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Book> findById(@PathVariable long id){
        return bookMService.findByBookId(id);
    }

    //@GetMapping("/findByName/{name}") 不支持中文输入
    @GetMapping("/findByName")
    public Flux<Book> findByNmae(@RequestParam String name){

        return bookMService.findByBookName(name);
    }
}
