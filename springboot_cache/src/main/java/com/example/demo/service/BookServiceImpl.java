package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookExample;
import com.example.demo.mapper.BookMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title:com.example.demo.service
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/01/25  16:04
 */
@Service
public class BookServiceImpl {

    @Autowired
    BookMapper mapper;

    @Cacheable(key = "#p0.bookId")
    public Book getBookByBookId(Book book){
        Book books = mapper.selectByPrimaryKey(book.getBookId());
        System.out.println("第二次查询不会出现。。。。。。。。");
        return books;
    }

    @CachePut(key="#p0.bookId")
    public Book UpdateByBookId(@Param("record") Book book,@Param("example") BookExample example){
        int update = mapper.updateByExampleSelective(book,example);
        return mapper.selectByPrimaryKey(book.getBookId());
    }

    @Cacheable(value = "book_mysql",key = "#p0")
    public Book getBookById(Long bookId){
        System.out.println("第二次查询不会出现。。。。。。。。");
        return mapper.selectBookById(bookId);
    }

    @CachePut(value = "book_mysql",key = "#p0.bookId")
    public Book updateById(Book bookId){
        mapper.updateById(bookId);
        return mapper.selectBookById(bookId.getBookId());
    }

    @Transactional
    public Book updateByBookId(Book book){
        mapper.updateByExample(book);
        return mapper.selectBookById(book.getBookId());
    }

    @CacheEvict(value = "book_mysql",key = "#p0")
    public int delete(Long bookId){
        BookExample example = new BookExample();
        example.createCriteria().andBookIdEqualTo(bookId);
        int a = mapper.deleteByExample(example);
        return 1;
    }

    @Cacheable(value = "books")
    public List<Book> selectAll(){
        PageHelper.startPage(1,6);
        List<Book> books = mapper.selectBook();
        return books;
    }

    @Autowired
    RedisTemplate redisTemplate;


}
