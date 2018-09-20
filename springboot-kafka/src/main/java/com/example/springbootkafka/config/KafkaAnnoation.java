package com.example.springbootkafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Title:com.example.springbootkafka.config
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/17  10:21
 */
@Configuration//声明Config
@EnableKafka//打开KafkaTemplate能力
public @interface KafkaAnnoation {
}
