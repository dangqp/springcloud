package com.example.javaemo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Title:com.example.javaemo.thread
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/27  15:24
 */
public class CallabetEST {
    public static void main(String[] args){
        CallabetEST callabetEST = new CallabetEST();

        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) ()->{
            int j = 0;
            for (; j < 100; j++) {
                System.out.println(Thread.currentThread().getName()+"----"+j);
            }
            return j;
        });

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"---iiiiii--"+i);
            if (i==20){
                new Thread(task,"有返回值").start();
            }
        }
        try {
            System.out.println("hfkahdfkahdfkadhf"+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
