package com.example.springbootwebflux.book_mysql;

import com.example.springbootwebflux.book_mysql.domain.Book;
import com.example.springbootwebflux.book_mysql.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Title:com.example.springbootwebflux.book_mysql
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/08  11:14
 */
@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;
    @GetMapping("/getAll")
    public Flux<Book> findAll(){
        Flux<Book> all = bookService.findAll();
        return all;
    }

    @GetMapping("/get/{id}")
    public Mono<Book> findById(@PathVariable("id") long id){
        return bookService.findBookById(id);
    }

}
