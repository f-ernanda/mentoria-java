package dev.fernanda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("dev.fernanda")
@PropertySource("classpath:database.properties")
public class DBConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${dbuser}")
    private String dbuser;
    @Value("${dbpassword}")
    private String dbpassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();

        driverManager.setDriverClassName(driver);
        driverManager.setUrl(url);
        driverManager.setUsername(dbuser);
        driverManager.setPassword(dbpassword);

        return driverManager;
    }
}
