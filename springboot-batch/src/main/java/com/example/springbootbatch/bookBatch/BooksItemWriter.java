package com.example.springbootbatch.bookBatch;

import com.example.springbootbatch.domain.Book;
import com.example.springbootbatch.mapper.BookMapper;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Title:com.example.springbootbatch.bookBatch
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  10:31
 */
public class BooksItemWriter implements ItemWriter<Book> {

    @Autowired
    BookMapper bookMapper;

    @Override
    public void write(List<? extends Book> list) throws Exception {

        list.stream().forEach(book->{
            bookMapper.updateByExample(book);
        });
    }
}
