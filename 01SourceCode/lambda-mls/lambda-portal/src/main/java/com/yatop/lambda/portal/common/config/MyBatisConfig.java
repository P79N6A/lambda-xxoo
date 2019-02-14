package com.yatop.lambda.portal.common.config;

import com.yatop.lambda.portal.common.interceptor.SqlStatementInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration("portalMybatisConfig")
@EnableTransactionManagement
@MapperScan(
        basePackages = {"com.yatop.lambda.portal.system.dao", "com.yatop.lambda.portal.job.dao"},
        sqlSessionFactoryRef = "portalSqlSessionFactory"
)
public class MyBatisConfig {

    @Bean("portalJdbcTemplate")
    @Qualifier("portalJdbcTemplate")
    public JdbcTemplate portalJdbcTemplate(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new JdbcTemplate(frameworkDataSource);
    }

    @Bean("portalSqlSessionTemplate")
    @Qualifier("portalSqlSessionTemplate")
    public SqlSessionTemplate portalSqlSessionTemplate(@Qualifier("portalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("portalSqlSessionFactory")
    @Qualifier("portalSqlSessionFactory")
    public SqlSessionFactory portalSqlSessionFactory(@Qualifier("frameworkDataSource") DataSource portalDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(portalDataSource);
        bean.setTypeAliasesPackage("com.yatop.lambda.portal.system.domain,com.yatop.lambda.portal.job.domain");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*/*.xml"));
        bean.setPlugins(new Interceptor[]{ com.yatop.lambda.framework.config.MybatisConfig.getPageInterceptor()} );
        return bean.getObject();
    }

/*
    @Bean("portalTransactionManager")
    public PlatformTransactionManager portalTransactionManager(@Qualifier("portalDataSource") DataSource portalDataSource) {
        return new DataSourceTransactionManager(portalDataSource);
    }
*/

    /**
     * 配置 sql打印拦截器
     * application.yml中 febs.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
    /*
    @Bean
    @ConditionalOnProperty(name = "febs.showsql", havingValue = "true")
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }
    */
}
