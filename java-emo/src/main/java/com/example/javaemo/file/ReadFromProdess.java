package com.example.javaemo.file;

import java.io.*;

/**
 * Title:com.example.javaemo.file
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  20:53
 */
public class ReadFromProdess {

    public static void main(String[] args){
        try {
            Process javac = Runtime.getRuntime().exec("javac");
            //获取子进程的输入流
            InputStream inputStream = javac.getInputStream();
            //获取子进程的错误流
            InputStream errorStream = javac.getErrorStream();
            //获取子进程的输出流
            OutputStream outputStream = javac.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
            String buff = null;
            while ((buff=bufferedReader.readLine())!=null){
                System.out.println(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
