package com.example.springbootbatch.job;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.springbootbatch.service.BookBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Title:com.example.springbootbatch.job
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  11:51
 */
@Component
public class BookDealBatchJob {

    @Autowired
    BookBatchService bookBatchService;

    long a= System.currentTimeMillis();
    @Scheduled(fixedRate = 50000)
    public void job(){
        System.out.println();
        bookBatchService.bookBatch();
        long b= System.currentTimeMillis();
        System.out.println(b-a);
    }

}
