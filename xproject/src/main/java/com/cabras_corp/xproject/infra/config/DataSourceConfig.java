package com.cabras_corp.xproject.infra.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        Dotenv dotenv = Dotenv.load();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dotenv.get("MYSQL_URL"));
        dataSource.setUsername(dotenv.get("MYSQL_USER"));
        dataSource.setPassword(dotenv.get("MYSQL_PASSWORD"));
        return dataSource;
    }
}
