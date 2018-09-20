package com.example.springbootkafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:com.example.springbootkafka.config
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/17  10:02
 */

@KafkaAnnoation
public class KafkaProducerConfig {

    /**
     * kafka.produce.servers=127.0.0.1:9092
     * kafka.producer.retries=0
     * kafka.producer.batch.size=4096
     * kafka.producer.linger=1
     * producer.buffer.memory=40960
     */

    @Value("${kafka.produce.servers}")
    private String servers;

    @Value("${kafka.producer.retries}")
    private int retries;

    @Value("${kafka.producer.batch.size}")
    private int batchSize;

    @Value("${kafka.producer.linger}")
    private int linger;

    @Value("${producer.buffer.memory}")
    private int bufferMemory;

    /**
     * kafka配置信息
     * @return
     */
    public Map<String,Object> producerConfigs(){
        Map<String, Object> producerConfig = new HashMap<>();
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,servers);
        producerConfig.put(ProducerConfig.RETRIES_CONFIG,retries);
        producerConfig.put(ProducerConfig.BATCH_SIZE_CONFIG,batchSize);
        producerConfig.put(ProducerConfig.LINGER_MS_CONFIG,linger);
        producerConfig.put(ProducerConfig.BUFFER_MEMORY_CONFIG,bufferMemory);
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return producerConfig;
    }

    /**
     * 配置producerfactory
     * @return
     */
    public ProducerFactory<String,String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /**
     * 配置kafkatemplete
     * @return
     */
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
