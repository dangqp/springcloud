package com.example.springbootbatch.basebatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Title:com.example.springbootbatch.basebatch
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  09:29
 */
@BatchAnnotation
public class BatchConfig {

    private static final Logger log = LoggerFactory.getLogger(BatchConfig.class);

    /***
     *用于注册
     * @param dataSource
     * @param transactionManager
     * @return
     */
    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager){

        //内存
        MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean();
        mapJobRepositoryFactoryBean.setTransactionManager(transactionManager);
        JobRepository jobRepository = null;
        try {
            mapJobRepositoryFactoryBean.afterPropertiesSet();
            jobRepository = mapJobRepositoryFactoryBean.getObject();
        } catch (Exception e) {
            log.error("创建jobRepository异常：{}",e.getMessage());
        }
        return jobRepository;
    }

    @Bean
    @Primary
    public SimpleJobLauncher simpleJobLauncher(JobRepository jobRepository){
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository);
        try {
            simpleJobLauncher.afterPropertiesSet();
        } catch (Exception e) {
            log.error("创建simpleJobLauncher异常：{}",e.getMessage());
        }
        return simpleJobLauncher;
    }
}
