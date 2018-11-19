package ru.otus.dz17.configuration;

import com.mongodb.MongoCredential;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;

@Configuration
//@Component
//@ConfigurationProperties("spring.data.mongodb")
@ConfigurationProperties("application")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.port}")
    private Integer password;

//    @Override
//    public MongoClient reactiveMongoClient() {
//        return null;
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return null;
//    }

//    private String host;
//    private int port;
//    private String database;
//    private String username;
//    private String password;
//
//
//    public String getHost() {
//        return host;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public String getDatabase() {
//        return database;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }

    @Override
    public MongoClient reactiveMongoClient() {
//        return MongoClients.create();
        return MongoClients.create(String.format("mongodb://%s:%d", host, port));
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
//
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create();
//
//    }
//
////    @Override
////    protected String getDatabaseName() {
////
////        return "test";
////
////    }
//
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(mongoClient(), getDatabaseName());
//
//    }

}
