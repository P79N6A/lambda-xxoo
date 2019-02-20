package com.yatop.lambda.framework.config;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration("frameworkMybatisConfig")
@EnableTransactionManagement
public class MyBatisConfig {

    @Value("${lambda-framework.log4jdbc.enable:false}")
    private boolean enableLog4jdbc;

    @Bean("frameworkDataSource")
    @Primary
    public DataSource frameworkDataSource(@Qualifier("orignalFrameworkDataSource") DataSource orignalFrameworkDataSource) {
        if(enableLog4jdbc) {
            return new DataSourceSpy(orignalFrameworkDataSource);
        } else {
            return orignalFrameworkDataSource;
        }
    }

    @Bean("orignalFrameworkDataSource")
    @ConfigurationProperties(prefix = "lambda-framework.datasource")
    public DataSource orignalFrameworkDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("frameworkJdbcTemplate")
    public JdbcTemplate frameworkJdbcTemplate(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new JdbcTemplate(frameworkDataSource);
    }

    @Bean("frameworkTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new DataSourceTransactionManager(frameworkDataSource);
    }

    //PageHelper: https://github.com/pagehelper/Mybatis-PageHelper/blob/v5.1.6/wikis/zh/HowToUse.md
    static public PageInterceptor getPageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
