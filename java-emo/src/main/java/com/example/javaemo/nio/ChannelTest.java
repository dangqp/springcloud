package com.example.javaemo.nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Title:com.example.javaemo.nio
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/15  14:28
 */
public class ChannelTest {
    public static void main(String[] args){
        File file = new File("ChannelTest.java");
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
            //将channel中的数据全部映射到bytebufer
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //字符集
            //Charset gbk = Charset.forName("GBK");  //java.nio.charset.MalformedInputException: Input length = 1
            Charset gbk = Charset.forName("UTF-8");
            outChannel.write(map);//实现文件内容的复制
            //复原原有的limit、position位置
            map.clear();
            CharsetDecoder charsetDecoder = gbk.newDecoder();
            //使用解码器将bytebuffer转换为charbuffer
            CharBuffer charBuffer = charsetDecoder.decode(map);
            System.out.println(charBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
