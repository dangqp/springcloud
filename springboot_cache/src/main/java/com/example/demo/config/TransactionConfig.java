package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Title:com.example.demo.config
 * Description: springboot事务
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/01/27  10:34
 */
public class TransactionConfig {

    @Autowired
    DataSource dataSource;
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(DataSource.class)
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(this.dataSource);
    }
}
