package com.example.springbootkafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Title:com.example.springbootkafka.consumer
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/17  11:33
 */
@Component
public class Comsumer {

    private static final Logger log = LoggerFactory.getLogger(Comsumer.class);

    @Value("${kafka.consumer.topic}")
    String topic;

    @KafkaListener(topics={"dangqp"})
    public void listen(ConsumerRecord<?,?> record){
        //for (ConsumerRecord<?, ?> record : records) {
            log.info("kafka的key："+record.key());
            log.info("kafka的value："+record.value().toString());
        //}
    }
}
