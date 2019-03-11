package com.example.springbootbatch.bookBatch;

import com.example.springbootbatch.domain.Book;
import org.springframework.batch.item.ItemProcessor;

/**
 * Title:com.example.springbootbatch.bookBatch
 * Description: 数据处理
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  10:29
 */

/**
 * public interface ItemProcessor<I, O> {
 *     O process(I var1) throws Exception;
 * }
 */
public class BooksItemProcessor implements ItemProcessor<Book,Book> {

    /**
     * 对数据进行处理
     * 如果不对数据进行处理直接返回对象即可
     * @param book
     * @return
     * @throws Exception
     */
    @Override
    public Book process(Book book) throws Exception {
        //对每个书的对象进行修改
        book.setNumber(null);
        return book;
    }
}
