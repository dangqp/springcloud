package com.example.springbootwebflux.book_mysql.mapper;


import com.example.springbootwebflux.book_mysql.domain.Book;
import com.example.springbootwebflux.book_mysql.domain.BookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_mysql
     *
     * @mbggenerated
     */
    int countByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_mysql
     *
     * @mbggenerated
     */
    int deleteByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_mysql
     *
     * @mbggenerated
     */
    List<Book> selectByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_mysql
     *
     * @mbggenerated
     */
    Book selectByPrimaryKey(Long bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_mysql
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_mysql
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Book record);

    int updateById(Book bookId);

    Book selectBookById(Long bookId);

    /**
     * 查询所有记录
     */
    List<Book> selectBook();
}