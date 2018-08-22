package ru.otus.dz10.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties("application")
public class PersistenceContext {

    @Autowired
    public Environment env;

//    @Bean(destroyMethod = "close")
    @Bean
//    DataSource dataSource(Environment env) {
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
//        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
//        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
//        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
//        dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
        dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));

        return new HikariDataSource(dataSourceConfig);
    }
}
