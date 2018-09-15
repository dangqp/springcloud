package com.example.springbootbatch;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.example.springbootbatch")
@EnableScheduling
public class SpringbootBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBatchApplication.class, args);
    }

    /**
     * 如果工程只用到一个数据库，直接去spring容器中的datasource即可
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.default")
    public DataSourceProperties defaultCurrDataSourceProperties(){
        return new DataSourceProperties();
    }
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.default")
    public DataSource dataSource(){
        return defaultCurrDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
