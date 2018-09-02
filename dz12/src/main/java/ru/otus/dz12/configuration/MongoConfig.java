package ru.otus.dz12.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.*;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    public Environment env;

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
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(new SimpleMongoDbFactory(mongoClient(), env.getRequiredProperty("spring.data.mongodb.database")));
    }
}
