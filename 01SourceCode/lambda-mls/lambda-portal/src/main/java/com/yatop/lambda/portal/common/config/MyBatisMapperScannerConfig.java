package com.yatop.lambda.portal.common.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration("portalMyBatisMapperScannerConfig")
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean(name = "portalMapperScannerConfigurer")
    public MapperScannerConfigurer portalMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("portalSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.yatop.lambda.portal.*.dao");
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.yatop.lambda.portal.common.config.MyMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}