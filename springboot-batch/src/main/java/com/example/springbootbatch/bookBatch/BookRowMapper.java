package com.example.springbootbatch.bookBatch;


import com.example.springbootbatch.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Title:com.example.springbootbatch.bookBatch
 * Description: 处理实体与数据库查询结果不一致问题
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  10:19
 */
public class BookRowMapper implements RowMapper<Book> {

    /**
     * 处理查询返回的实体字段与实体对象不一致问题
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setBookId(resultSet.getLong("BOOK_ID"));
        book.setName(resultSet.getString("NAME"));
        book.setNumber(resultSet.getInt("NUMBER"));
        return book;
    }
}
