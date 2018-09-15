package com.example.javaemo.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Title:com.example.javaemo.file
 * Description: 重定向：输入
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  20:43
 */
public class FileReIn {
    public static void main(String[] args){

        try {
            FileInputStream fi = new FileInputStream("RedirectFile.java");
            //将输入流重定向到fi
            System.setIn(fi);
            //使用system.in创建scanner对象
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                System.out.println("键盘输入内容"+scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
