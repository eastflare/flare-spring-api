package com.flare.rap.common.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
        basePackages = {"com.flare"},
        sqlSessionFactoryRef = "primarySessionFactory",
        annotationClass = Mapper.class)
@RequiredArgsConstructor
@ConditionalOnExpression(
        "!T(org.springframework.util.StringUtils).isEmpty('${spring.datasource.primary.jdbc-url:}')")
public class DataSourceConfig {

    private final ApplicationContext applicationContext;

    @Value("${mybatis.mapper-locations.primary}")
    private String mapperLocations;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Primary
    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() { return DataSourceBuilder.create().build(); }

    @Primary
    @Bean(name="primarySessionFactory")
    public SqlSessionFactory primarySessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(primaryDataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/mybatis.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperLocations));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "primarySessionTemplate")
    public SqlSessionTemplate primarySessionTemplate(SqlSessionFactory primarySessionFactory) throws Exception{

        return new SqlSessionTemplate(primarySessionFactory);
    }

}
