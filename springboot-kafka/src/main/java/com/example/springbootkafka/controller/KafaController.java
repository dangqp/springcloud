package com.example.springbootkafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:com.example.springbootkafka.controller
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/17  14:21
 */
@RestController
@RequestMapping("/kafka")
public class KafaController {

    private static final Logger log = LoggerFactory.getLogger(KafaController.class);
    
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/send")
    public void send(@RequestParam String msg){
        /**
         * 解决控制台乱码
         * chcp 936 设置成GBK （一般我们设置成这一项就可以显示中文了）
         * chcp 65001 设置UTF-8代码页
         * chcp 437 设置成美国英语
         */
        log.info("kafa发送信息开始");
        byte[] bytes = msg.getBytes();
        ListenableFuture send = kafkaTemplate.send("dangqp", "dangqp", msg);
        send.addCallback(data->log.info("消息发送成功={}",msg),throwable -> log.info("消息发送失败={}",msg));
        log.info("kafa发送信息结束");
    }
}
