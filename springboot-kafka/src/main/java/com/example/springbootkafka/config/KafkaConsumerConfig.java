package com.example.springbootkafka.config;

import com.example.springbootkafka.consumer.Comsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

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
 * @created 2018/09/17  10:21
 */
@KafkaAnnoation
public class KafkaConsumerConfig {

    /**
     * kafka.consumer.zookeeper.connect = 127.0.0.1:2181
     * kafka.consumer.server=127.0.0.1:9092
     * kafka.consumer.enable.auto.commit=true
     * kafka.consumer.session.timeout=6000
     * kafka.consumer.auto-commit-interval=100
     * kafka.consumer.topic=dangqp
     * kafka.consumer.group-id=dangqp
     * kafka.consumer.concurrency=10
     */
    @Value("${kafka.consumer.server}")
    private String servers;

    @Value("${kafka.consumer.enable.auto.commit}")
    private boolean autoCommit;

    @Value("${kafka.consumer.session.timeout}")
    private int timeOut;

    @Value("${kafka.consumer.auto-commit-interval}")
    private int autoCommitInterval;

    @Value("${kafka.consumer.topic}")
    private String topic;

    @Value("${kafka.consumer.group-id}")
    private String groupId;

    @Value("${kafka.consumer.concurrency}")
    private int concurrency;

    public Map<String,Object> consumerConfig(){
        Map<String, Object> consumerConfig = new HashMap<>();
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,servers);
        consumerConfig.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,autoCommit);
        consumerConfig.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,timeOut);
        consumerConfig.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,autoCommitInterval);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return consumerConfig;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(concurrency);
        factory.getContainerProperties().setPollTimeout(1500);
        return factory;
    }

   /* @Bean
    public Comsumer listener() {
        return new Comsumer();
    }*/

}
