package com.orderserver.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

/**
 * Created by proton on 27.01.2016.
 */
@Configuration
@EnableScheduling
public class MainConfig {

    @Value("${POSTGRES_URL:jdbc:postgresql://127.0.0.1:5432/orderserver}")
    private String url;

    @Value("${POSTGRES_USERNAME:postgres}")
    private String username;

    @Value("${POSTGRES_PASSWORD:postgres}")
    private String password;

    @Bean
    public DataSource makeDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
