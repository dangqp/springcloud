package com.example.springbootwebflux.book_mysql.service;

import com.example.springbootwebflux.book_mysql.domain.Book;
import com.example.springbootwebflux.book_mysql.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Title:com.example.springbootwebflux.book_mysql.service
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/08  11:08
 */
@Service
public class BookServiceImpl {

    @Autowired
    BookMapper bookMapper;

    public Flux<Book> findAll(){
        return Flux.create(bookFluxSink -> {
            bookMapper.selectBook().stream().forEach(b->{
                bookFluxSink.next(b);
            });
            bookFluxSink.complete();
        });
    }

    public Mono<ServerResponse> findAll1(){
        /*return Flux.create(bookFluxSink -> {
            bookMapper.selectBook().stream().forEach(b->{
                bookFluxSink.next(b);
            });
            bookFluxSink.complete();
        });
*/
       return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject( bookMapper.selectBook()));
    }

    public Mono<Book> findBookById(Long id){
        Book book = bookMapper.selectBookById(id);
        return Mono.just(book);
    }

    public Mono<Book> findBookById1(Long id){
        Book book = bookMapper.selectBookById(id);
        return Mono.create(bookMonoSink -> {
            bookMonoSink.success(book);
        });
    }

    public List<Book> findAllBook(){
        return bookMapper.selectBook();
    }
}
