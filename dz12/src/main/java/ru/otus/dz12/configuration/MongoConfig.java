package ru.otus.dz12.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.*;

//@Ignore
@Configuration
//@ConfigurationProperties("spring.data.mongodb")
//@ConfigurationProperties("application")
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    public Environment env;

//    @Value("${spring.data.mongodb.host}")
//    private String host;
//
//    @Value("${spring.data.mongodb.port}")
//    private Integer port;
//
//    @Value("${spring.data.mongodb.username}")
//    private String username;
//
//    @Value("${spring.data.mongodb.database}")
//    private String database;
//
//    @Value("${spring.data.mongodb.password}")
//    private String password;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(Collections.singletonList(
                new ServerAddress(env.getRequiredProperty("spring.data.mongodb.host"),
                Integer.valueOf(env.getRequiredProperty("spring.data.mongodb.port")))),
                Collections.singletonList(
                        MongoCredential.createCredential(env.getRequiredProperty("spring.data.mongodb.username"),
                                "admin", env.getRequiredProperty("spring.data.mongodb.password").toCharArray())));
        //MongoCredential.createCredential("sergya", "admin", "otusotus".toCharArray())));
    }

    @Override
    protected String getDatabaseName() {
        return env.getRequiredProperty("spring.data.mongodb.database");
//        return "lib";
//        return database;
    }

//    @Override
//    public MongoClient mongoClient() {
////        System.out.println("host = " + host);
//        return new MongoClient("188.227.18.141", 27017);
////                env.getRequiredProperty("spring.data.mongodb.host"),
////                Integer.valueOf(env.getRequiredProperty("spring.data.mongodb.port")))
////                host,27017);
////                Integer.valueOf(env.getRequiredProperty("spring.data.mongodb.port")));
//    }
}
