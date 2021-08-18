package com.example.storageservice.config;


import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SeataDataSource {

    @Value("${spring.datasource1.username}")
    private String username1;

    @Value("${spring.datasource1.password}")
    private String password1;

    @Value("${spring.datasource1.url}")
    private String url1;

    @Value("${spring.datasource1.driver-class-name}")
    private String driver1;



    @Value("${spring.application.name}")
    private String applicationName;


    @Value("${spring.datasource2.username}")
    private String username2;

    @Value("${spring.datasource2.password}")
    private String password2;

    @Value("${spring.datasource2.url}")
    private String url2;
    @Value("${spring.datasource2.driver-class-name}")
    private String driver2;





    @Bean(name = "seataDataSource1")
    public DataSource getDataSource1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url1);
        dataSource.setUsername(username1);
        dataSource.setPassword(password1);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(3000);
        return new DataSourceProxy(dataSource);
    }


    @Bean(name = "DataSource1")
    public DataSource getDataSource0(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url1);
        dataSource.setUsername(username1);
        dataSource.setPassword(password1);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(3000);
        return dataSource;
    }



    @Bean(name = "seataDataSource2")
    public DataSource getDataSource2(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url2);
        dataSource.setUsername(username2);
        dataSource.setPassword(password2);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(3000);
        return new DataSourceProxy(dataSource);
    }


    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner(this.applicationName,"my_test_tx_group");
    }


}
