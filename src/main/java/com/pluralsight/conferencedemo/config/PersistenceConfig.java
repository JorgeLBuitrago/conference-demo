package com.pluralsight.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {
/*
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/postgres-demo");
        builder.username("postgres");
        builder.password("5384607j");
        System.out.println("JAJAJAJAJA I WAS OVERWRITTEN!!!!!!!");
        return builder.build();
    }
*/
}
