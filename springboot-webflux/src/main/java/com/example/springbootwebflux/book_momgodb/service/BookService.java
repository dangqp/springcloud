package com.example.springbootwebflux.book_momgodb.service;

import com.example.springbootwebflux.book_momgodb.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Title:com.example.springbootwebflux.book_momgodb.service
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/08  12:52
 */
public interface BookService extends MongoRepository<Book,Long>{
}
