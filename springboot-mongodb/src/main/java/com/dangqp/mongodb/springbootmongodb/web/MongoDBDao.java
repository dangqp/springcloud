package com.dangqp.mongodb.springbootmongodb.web;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface MongoDBDao {
    /**
     * 插入一个Object类型的
     * @param object
     */
    void insert(Object object);

    /**
     * 保存一条记录
     * @param obj
     */
    void save(Object obj);

    /**
     * 查询一条记录
     * @param clazz
     * @param query
     * @return
     */
    <T> T findOne(Class<T> clazz, Query query);

    /**
     * 查询所有
     * @param clazz
     * @return
     */
    <T> List<T> findAll(Class<T> clazz);

    /**
     * 根据ID查询一个对象
     * @param clazz
     * @param id
     * @return
     */
    <T> T findById(Class<T> clazz,Object id);

    /**
     * 根据条件查询集合对象
     * @param clazz
     * @param query
     * @return
     */
    <T> List<T> find(Class<T> clazz, Query query);

    /**
     * 根据条件查询分页集合对象
     * @param clazz
     * @param query
     * @param currentPage
     * @param pageSize
     * @return
     */
    <T> List<T> findList(Class<T> clazz,Query query,int currentPage,int pageSize);

    /**
     * 根据条件查询总条数
     * @param clazz
     * @param query
     * @return
     */
    <T> long findCount(Class<T> clazz,Query query);

    /**
     * 根据条件更新一条记录
     * @param query
     * @param update
     * @param clazz
     * @return
     */
    <T> int update(Query query, Update update, Class<T> clazz);
}