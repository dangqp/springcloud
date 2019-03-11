package com.example.springbootwebflux.book_momgodb.service.impl;

import com.example.springbootwebflux.book_momgodb.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Title:com.example.springbootwebflux.book_momgodb.service.impl
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/08  12:55
 */
@Service
public class BookMServiceImpl {

    @Autowired
    MongoOperations mongoOperations;

    /**
     * 保存一个固定对象
     * @return
     */
    public Mono<Book> save(){
        Book book = Book.builder().build();
        book.setBookId(1L);
        book.setName("java");
        book.setNumber(1);
        mongoOperations.save(book);
        return Mono.create(bookMonoSink -> {
            bookMonoSink.success();
        });
    }

    /**
     * 查询全部数据
     * @return
     */
    public Flux<Book> findAll(){
        return Flux.create(bookFluxSink -> {
            mongoOperations.findAll(Book.class).stream().forEach(book -> {
                bookFluxSink.next(book);
            });
            bookFluxSink.complete();
        });
    }

    /**
     * 依据bookID查询对应的信息
     * @param bookId
     * @return
     */
     public Mono<Book> findByBookId(Long bookId){
        Query query = new Query();
         Criteria criteria = new Criteria();
         criteria.and("bookId").is(bookId);
         query.addCriteria(criteria);
        return Mono.create(bookMonoSink -> {
            bookMonoSink.success(mongoOperations.findOne(query,Book.class));
        });
     }

    /**
     * 依据名称进行查询
     * @param bookName
     * @return
     */
     public Flux<Book> findByBookName(String bookName){
         Query query = new Query();
         Pattern pattern = Pattern.compile("^.*"+bookName+".*$", Pattern.CASE_INSENSITIVE);
         Criteria name = Criteria.where("name").regex(pattern);
         query.addCriteria(name);
         List<Book> books = mongoOperations.find(query, Book.class);

         return Flux.create(bookFluxSink -> {
             books.stream().forEach(book -> {
                 bookFluxSink.next(book);
             });
             bookFluxSink.complete();
         });
     }

    public List<Book> findByBookName1(String bookName){
        Query query = new Query();
        Pattern pattern = Pattern.compile("^.*"+bookName+".*$", Pattern.CASE_INSENSITIVE);
        Criteria name = Criteria.where("name").regex(pattern);
        query.addCriteria(name);
        List<Book> books = mongoOperations.find(query, Book.class);
        return books;
    }
}
