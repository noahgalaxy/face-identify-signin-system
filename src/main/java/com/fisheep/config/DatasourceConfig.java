package com.fisheep.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.fisheep.constant.DataSourceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatasourceConfig {

    @Bean
    @Qualifier(DataSourceConstants.DEFAULT_DATA_SOURCE)
    @ConfigurationProperties("spring.datasource.druid.mysql")
    public DataSource mysqlDataSource(){
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean
    @Qualifier(DataSourceConstants.OPENLOOKEENG_DATA_SOURCE)
    @ConfigurationProperties("spring.datasource.druid.openlookeng")
    public DataSource openlookengDataSource(){
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }


    @Primary
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(mysqlDataSource());

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceConstants.DEFAULT_DATA_SOURCE, mysqlDataSource());
        dataSourceMap.put(DataSourceConstants.OPENLOOKEENG_DATA_SOURCE, openlookengDataSource());

        dynamicDataSource.setTargetDataSources(dataSourceMap);

        return dynamicDataSource;
    }


//    对此数据源加入事务管理
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
