package com.example.springbootwebflux.book_mysql.domain;

import java.io.Serializable;

public class Book implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_mysql.book_id
     *
     * @mbggenerated
     */
    private Long bookId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_mysql.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_mysql.number
     *
     * @mbggenerated
     */
    private Integer number;

    /**
     * 此类必须由空参构造器，因JACKSON做序列化需要
     */
    public Book() {
    }

    public Book(Long bookId, String name, Integer number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_mysql.book_id
     *
     * @return the value of book_mysql.book_id
     *
     * @mbggenerated
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_mysql.book_id
     *
     * @param bookId the value for book_mysql.book_id
     *
     * @mbggenerated
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_mysql.name
     *
     * @return the value of book_mysql.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_mysql.name
     *
     * @param name the value for book_mysql.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_mysql.number
     *
     * @return the value of book_mysql.number
     *
     * @mbggenerated
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_mysql.number
     *
     * @param number the value for book_mysql.number
     *
     * @mbggenerated
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}