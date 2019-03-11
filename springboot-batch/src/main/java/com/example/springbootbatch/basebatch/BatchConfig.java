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
     * Job Repository来存储Job执行期的元数据（这里的元数据是指Job Instance、Job Execution、Job Parameters、
     * Step Execution、Execution Context等数据），并提供两种默认实现。
     *
     * 一种是存放在内存中；另一种将元数据存放在数据库中。通过将元数据存放在数据库中，可以随时监控批处理Job的执行状态。
     * Job执行结果是成功还是失败，并且使得在Job失败的情况下重新启动Job成为可能。Step表示作业中的一个完整步骤，一个Job可以有一个或者多个Step组成。
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
