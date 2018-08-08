package com.dangqp.mongodb.springbootmongodb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBServiceImpl implements MongoDBService{

    @Autowired
    private MongoDBDao mongoDBDAO;

    @Override
    public void insert(Object object) {
        mongoDBDAO.insert(object);
    }

    @Override
    public void save(Object obj) {
        mongoDBDAO.save(obj);
    }


    @Override
    public <T> T findOne(Class<T> clazz, Query query) {
        return mongoDBDAO.findOne(clazz, query);
    }


    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        return mongoDBDAO.findAll(clazz);
    }


    @Override
    public <T> T findById(Class<T> clazz, Object id) {
        return mongoDBDAO.findById(clazz, id);
    }


    @Override
    public <T> List<T> find(Class<T> clazz, Query query) {
        return mongoDBDAO.find(clazz, query);
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public  <T> Page<T> getPagination(Class<T> clazz, Query query, int currentPage, int pageSize) {
        List<T> recordList = mongoDBDAO.findList(clazz, query, currentPage, pageSize);
        int recordCount = (int)mongoDBDAO.findCount(clazz, query);
       // return new Page(currentPage,pageSize,recordCount,recordList);
        return null;
    }


    @Override
    public <T> long findCount(Class<T> clazz, Query query) {
        return mongoDBDAO.findCount(clazz, query);
    }


    @Override
    public <T> int update(Query query, Update update, Class<T> clazz) {
        return mongoDBDAO.update(query, update, clazz);
    }

}