package com.yatop.lambda.manager.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration("managerMybatisConfig")
@EnableTransactionManagement
@MapperScan(
        basePackages = {"com.yatop.lambda.base.mapper", "com.yatop.lambda.base.extend.mapper"},
        sqlSessionFactoryRef = "managerSqlSessionFactory"
)
public class MyBatisConfig {

    @Bean("managerJdbcTemplate")
    public JdbcTemplate managerJdbcTemplate(@Qualifier("portalDataSource") DataSource portalDataSource) {
        return new JdbcTemplate(portalDataSource);
    }

    @Bean("managerSqlSessionTemplate")
    public SqlSessionTemplate managerSqlSessionTemplate(@Qualifier("managerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("managerSqlSessionFactory")
    public SqlSessionFactory managerSqlSessionFactory(@Qualifier("portalDataSource") DataSource managerDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(managerDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("com/yatop/lambda/base/sqlmapper/*.xml"));
        bean.setPlugins(new Interceptor[]{ com.yatop.lambda.portal.common.config.MyBatisConfig.getPageInterceptor()} );
        return bean.getObject();
    }

/*
    @Bean("managerTransactionManager")
    public PlatformTransactionManager managerTransactionManager(@Qualifier("managerDataSource") DataSource portalDataSource) {
        return new DataSourceTransactionManager(portalDataSource);
    }
*/
}
