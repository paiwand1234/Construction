package com.mvcspring.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConnection {

    @Bean
    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String Driver = "com.mysql.cj.jdbc.Driver";
        String DatabaseName = "paiwand_database";
        String Url = "jdbc:mysql://localhost:3306/"+DatabaseName;
        String Username = "root";
        String Password = "";
        dataSource.setDriverClassName(Driver);
        dataSource.setUrl(Url);
        dataSource.setUsername(Username);
        dataSource.setPassword(Password);
        return dataSource;
    }

    // Other configuration methods
}