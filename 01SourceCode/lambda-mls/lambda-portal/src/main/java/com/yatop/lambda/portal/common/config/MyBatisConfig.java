package com.yatop.lambda.portal.common.config;

import com.github.pagehelper.PageInterceptor;
import com.yatop.lambda.portal.common.interceptor.SqlStatementInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration("portalMybatisConfig")
@EnableTransactionManagement
public class MyBatisConfig {

    @Bean("portalDataSource")
    @Primary
    public DataSource portalDataSource(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
            return frameworkDataSource;
    }

    @Bean("portalJdbcTemplate")
    public JdbcTemplate portalJdbcTemplate(@Qualifier("portalDataSource") DataSource portalDataSource) {
        return new JdbcTemplate(portalDataSource);
    }

    @Bean("portalSqlSessionTemplate")
    public SqlSessionTemplate portalSqlSessionTemplate(@Qualifier("portalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("portalSqlSessionFactory")
    public SqlSessionFactory portalSqlSessionFactory(@Qualifier("portalDataSource") DataSource portalDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(portalDataSource);
        bean.setTypeAliasesPackage("com.yatop.lambda.portal.system.domain,com.yatop.lambda.portal.job.domain");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*/*.xml"));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        bean.setConfiguration(configuration);

        bean.setPlugins(new Interceptor[]{ com.yatop.lambda.framework.config.MyBatisConfig.getPageInterceptor()} );
        return bean.getObject();
    }

    /*@Bean("portalTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("portalDataSource") DataSource portalDataSource) {
        return new DataSourceTransactionManager(portalDataSource);
    }*/

    /**
     * 配置 sql打印拦截器
     * application.yml中 lambda-portal.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
    /*
    @Bean
    @ConditionalOnProperty(name = "lambda-portal.showsql", havingValue = "true")
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }
    */
}
