package com.example.springbootbatch.service;

import com.example.springbootbatch.domain.Book;
import com.example.springbootbatch.mapper.BookMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:com.example.springbootbatch.service
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  11:47
 */
@Service
public class BookBatchService {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Autowired
    BookMapper bookMapper;

    public void bookBatch(){

        List<Book> books = bookMapper.selectBook();
        //for (Book book : books) {
            // batch parameter
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("booksJob","booksJob")
                    .toJobParameters();
            JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
            try {
                jobLauncher.run(applicationContext.getBean("booksJob",Job.class),jobParameters);
            } catch (JobExecutionAlreadyRunningException e) {
                e.printStackTrace();
            } catch (JobRestartException e) {
                e.printStackTrace();
            } catch (JobInstanceAlreadyCompleteException e) {
                e.printStackTrace();
            } catch (JobParametersInvalidException e) {
                e.printStackTrace();
            }
        //}

    }
}
