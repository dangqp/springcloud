package com.example.javaemo.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Title:com.example.javaemo.file
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/15  10:06
 */
public class RandomAccessFileTest {

    @Test
    public void testRandom1(){
        RandomAccessFile randomAccessFile = null;
        try{
            //将指针移到文件最后
            randomAccessFile = new RandomAccessFile("out.txt","rw");
            randomAccessFile.seek(10);
            randomAccessFile.write("你好啊 \\rn".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insert(String fileName,long pos,String insertContent){

        try {
            File tempFile = File.createTempFile("tmp", null);
            tempFile.deleteOnExit();
            RandomAccessFile rw = new RandomAccessFile("out.txt", "rw");
            //使用临时文件保存插入节点后的文件内容
            FileOutputStream tempOut = new FileOutputStream(tempFile);
            FileInputStream tempIn = new FileInputStream(tempFile);

            rw.seek(pos);
            // save 插入点后的文件
            byte[] buff = new byte[64];
            int hasRead = 0;
            while ((hasRead = rw.read(buff))>0){
                //写入到临时文件
                tempOut.write(buff,0,hasRead);
            }
            //插入内容
            rw.seek(pos);
            rw.write(insertContent.getBytes());
            //追加临时文件的内容
            while ((hasRead=tempIn.read(buff))>0){
                rw.write(buff,0,hasRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Test
    public void test1(){
        insert("out.txt",10,"你好哈哈哈");
    }

    @Test
    public void testPersion(){
        Persion persion = new Persion("12222",20);
        System.out.println(persion);
        System.out.println(persion.getName());
        System.out.println(persion.getAge());
    }
}
