package com.example.boardcontent;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.boardcontent.**.dao"}, sqlSessionFactoryRef = "oracleOneSqlSessionFactory")
public class MybatisDbOneConfig {


    @Bean(name = "oracleOneDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    @Primary
    public DataSource oracleOneDatasource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "oracleOneSqlSessionFactory")
    @Primary
    public SqlSessionFactory oracleOneSqlSessionFactory(@Qualifier(value = "oracleOneDatasource") DataSource oracleOneDatasource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(oracleOneDatasource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //oracle mapper 설정
        bean.setMapperLocations(resolver.getResources("classpath:mapper/oracle/one/**/*.xml"));

        return bean.getObject();

    }

    @Bean(name = "oracleOneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate oracleOneSqlSessionTemplate(@Qualifier(value = "oracleOneSqlSessionFactory") SqlSessionFactory oracleOneSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(oracleOneSqlSessionFactory);
    }
}