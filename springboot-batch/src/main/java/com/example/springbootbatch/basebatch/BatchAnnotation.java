package com.example.springbootbatch.basebatch;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Title:com.example.springbootbatch.bookBatch
 * Copyright: Copyright (c) 2018
 * 整合注解@EnableBatchProcessing和@ComponentScan(basePackageClasses = DefaultBatchConfigurer.class)
 * @author dangqp
 * @version 1.0
 * @created 2018/09/12  09:08
 */
@Configuration //告诉spring这是个配置并注入spring容器内
@EnableBatchProcessing//开启springbatch
@ComponentScan(basePackageClasses = DefaultBatchConfigurer.class)
public @interface BatchAnnotation {
}
