package com.example.springbootbatch.bookBatch;

import com.example.springbootbatch.basebatch.BaseBatchConfig;
import com.example.springbootbatch.basebatch.BatchAnnotation;
import com.example.springbootbatch.basebatch.BookItemWriteListener;
import com.example.springbootbatch.basebatch.JobExecutionListener;
import com.example.springbootbatch.domain.Book;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Title:com.example.springbootbatch.bookBatch
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  10:45
 */
//@BatchAnnotation
@Deprecated
public class BookDataToBatch extends BaseBatchConfig {

    /**
     * 此种写法报错 DataSource is can not null
     * @return
     */
    @Bean
    @StepScope
    public JdbcPagingItemReader<Book> reader(){
        return new JdbcPagingItemReader<Book>();
    }

    @Bean
    @StepScope
    public BooksItemProcessor processor(){
        return new BooksItemProcessor();
    }
    @Bean
    @StepScope
    public ItemWriter<Book> bookItemWriter(){
        return new BooksItemWriter();
    }

    @Bean
    @JobScope
    public Step bookDealStep(){
        return stepBuilderFactory.get("bookDealStep")
                .<Book,Book>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(bookItemWriter())
                .taskExecutor(new SimpleAsyncTaskExecutor())
                .throttleLimit(20)
                .build();
    }

    @Bean
    public Job booksJob(JobExecutionListener listener){

        JobBuilder jobBuilder = jobBuilderFactory.get("booksJob").incrementer(new RunIdIncrementer()).listener(listener);
        FlowJobBuilder flowJobBuilder = new FlowJobBuilder(jobBuilder);

        return jobBuilderFactory.get("booksJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(bookDealStep()) //开始
                //.next() 下一步
                .build();

    }
}
