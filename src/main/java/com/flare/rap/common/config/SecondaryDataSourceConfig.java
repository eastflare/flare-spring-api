package com.flare.rap.common.config;

import javax.sql.DataSource;

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

import com.flare.rap.common.annotation.SecondaryMapper;

import lombok.RequiredArgsConstructor;

@Configuration
@MapperScan(
        basePackages = {"com.lgensol"},
        sqlSessionFactoryRef = "secondarySessionFactory",
        annotationClass = SecondaryMapper.class)
@RequiredArgsConstructor
@ConditionalOnExpression(
        "!T(org.springframework.util.StringUtils).isEmpty('${spring.datasource.secondary.jdbc-url:}')")
public class SecondaryDataSourceConfig {

    private final ApplicationContext applicationContext;

    @Value("${mybatis.mapper-locations.primary:classpath:sql/secondary/core/*.xml}")
    private String mapperLocation;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Bean(name="secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondarydb")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondarySessionFactory")
    public SqlSessionFactory secondarySessionFactory(@Qualifier("secondaryDataSource") DataSource secondaryDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(secondaryDataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/mybatis.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperLocation));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "secondarySqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate(@Qualifier("secondarySqlSessionFactory")  SqlSessionFactory secondarySqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(secondarySqlSessionFactory);
    }
}