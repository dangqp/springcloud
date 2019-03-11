package com.example.springbootbatch.basebatch;

import com.example.springbootbatch.domain.Book;
import com.example.springbootbatch.mapper.BookMapper;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Title:com.example.springbootbatch.basebatch
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  16:13
 */
@Component
public class BookItemWriteListener implements ItemWriteListener<Book> {

    @Autowired
    BookMapper bookMapper;

    @Override
    public void beforeWrite(List<? extends Book> items) {
        System.out.println("SimpleItemWriteListener.beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends Book> items) {
        System.out.println("SimpleItemWriteListener.afterWrite");
    }

    @Override
    public void onWriteError(Exception exception, List<? extends Book> items) {

        System.out.println("-------------"+items.size());
        for (Book item : items) {
            System.out.println(item.toString());
        }
        System.out.println("SimpleItemWriteListener.onWriteError");
    }

}
