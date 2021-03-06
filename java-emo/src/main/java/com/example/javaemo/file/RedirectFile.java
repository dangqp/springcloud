package com.example.javaemo.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Title:com.example.javaemo.file
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  19:50
 */
public class RedirectFile {
    public static void main(String[] args){

        try {
            PrintStream ps =new PrintStream(new FileOutputStream("out.txt"));
            //重定向
            System.setOut(ps);
            System.out.println("这是重定向测试");
            //向表中输出一个对象
            System.out.println(new RedirectFile());
            System.out.println("测试车位都会发生款到发货");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
