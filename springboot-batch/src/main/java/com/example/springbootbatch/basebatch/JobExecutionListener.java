package com.example.springbootbatch.basebatch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * Title:com.example.springbootbatch.basebatch
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  09:50
 */
@Component
public class JobExecutionListener extends JobExecutionListenerSupport {


    public JobExecutionListener() {
        super();
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        JobParameters jobParameters = jobExecution.getJobParameters();
        Long bookId = jobParameters.getLong("bookId");
        System.out.println("0-------------------------0-----------------9-----------"+bookId);
        if (jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("这里可以写成功处理逻辑");
        }else if (jobExecution.getStatus() == BatchStatus.FAILED){
            System.out.println("处理失败的业务逻辑");
        }
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        super.beforeJob(jobExecution);
        System.out.println("z在job开始之前处理逻辑");
        /*while (true){
            boolean trueLoop = isTrueLoop();
            if (trueLoop){
                break;
            }
        }*/

    }

    private boolean isTrueLoop() {
        boolean aTrue = isTrue();
        System.out.println("开始休眠");
        if (!aTrue){
            try {
                Thread.sleep(3000);
                aTrue = isTrue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return aTrue;
    }

    public boolean isTrue(){

        if (1!=2){
            return true;
        }
        return false;
    }
}
