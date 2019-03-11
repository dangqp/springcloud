package com.example.javaemo.nio2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Title:com.example.javaemo.nio2
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/20  17:23
 */
public class PathsTest {

    @Test
    public void testPaths() throws IOException {
        Path path = Paths.get(".");
        System.out.println("path里包含的路径："+path.getNameCount());
        Path path1 = path.toAbsolutePath();
        System.out.println(path1);
        Files.lines(Paths.get("D:\\personal_work\\springcloud-learning\\java-emo\\src\\main\\java\\com\\example\\javaemo\\nio2\\PathsTest.java"), Charset.forName("utf-8")).forEach(p->{
            System.out.println(p);
        });
    }
}
