package com.example.springbootbatch.bookBatch;

import com.example.springbootbatch.basebatch.BaseBatchConfig;
import com.example.springbootbatch.basebatch.BatchAnnotation;
import com.example.springbootbatch.basebatch.BookItemWriteListener;
import com.example.springbootbatch.basebatch.JobExecutionListener;
import com.example.springbootbatch.domain.Book;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Title:com.example.springbootbatch.bookBatch
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  10:01
 */
@BatchAnnotation
public class DataToBatchItemReader extends BaseBatchConfig {
    private final int PAGE_ZIAE = 10;

    @Autowired
    DataSource dataSource;
    @Autowired
    BookItemWriteListener writeListener;

    int i = 0;

    @Bean
    @StepScope
    //public JdbcPagingItemReader<Book> booksItemReader(@Value("#{jobParameters['bookId']}")Long bookId){
    public JdbcPagingItemReader<Book> booksItemReader(){
        System.out.println("=================================="+i++);
        Map<String, Object> hashMap = new HashMap<>();
        //hashMap.put("bookId", bookId);
        //create jdbc reader
        JdbcPagingItemReader<Book> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setPageSize(PAGE_ZIAE);
        reader.setParameterValues(hashMap);
        //create use database query
        MySqlPagingQueryProvider mySqlPagingQueryProvider = new MySqlPagingQueryProvider();
        mySqlPagingQueryProvider.setSelectClause("SELECT * ");
        mySqlPagingQueryProvider.setFromClause("FROM BOOK ");
        //mySqlPagingQueryProvider.setWhereClause("where book_id="+bookId);
        mySqlPagingQueryProvider.setSortKeys(new HashMap<String,Order>(){
            {put("BOOK_ID", Order.ASCENDING);}
        });
        //put provider in reader
        reader.setQueryProvider(mySqlPagingQueryProvider);
        // if the entity`s column is diferent from db`s table
        //use rowmapper to deal this
        // if query use "as" to deal this problem
        // then this rowmapper is unnecessary
        reader.setRowMapper(new BookRowMapper());
        return reader;
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

   /* @Bean
    @StepScope
    public BookItemWriteListener writeListener(){
        return new BookItemWriteListener();
    }*/

    @Bean
    @JobScope
    public Step bookDealStep(BookItemWriteListener writeListener){
        return stepBuilderFactory.get("bookDealStep")
                .<Book,Book>chunk(10)
                .reader(booksItemReader())//数据来源的方法
                .processor(processor())//对数据进行处理
                .listener(writeListener)
                .writer(bookItemWriter())//写操作
                .taskExecutor(new SimpleAsyncTaskExecutor())
                .throttleLimit(20)
                .build();
    }

    @Bean
    public Job booksJob(JobExecutionListener listener,BookItemWriteListener writeListener){

        JobBuilder jobBuilder = jobBuilderFactory.get("booksJob").incrementer(new RunIdIncrementer()).listener(listener);
        FlowJobBuilder flowJobBuilder = new FlowJobBuilder(jobBuilder);

        return jobBuilderFactory.get("booksJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(bookDealStep(writeListener)) //开始
                //.next() 下一步
                .build();

    }
}
