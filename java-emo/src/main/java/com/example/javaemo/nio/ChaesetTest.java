package com.example.javaemo.nio;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Title:com.example.javaemo.nio
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/20  17:04
 */
public class ChaesetTest {

    @Test
    public void testCharset(){
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        for (String s : stringCharsetSortedMap.keySet()) {
            System.out.println(s);
        }
    }
}
