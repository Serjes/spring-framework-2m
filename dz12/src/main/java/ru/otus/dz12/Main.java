package ru.otus.dz12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.dz12.configuration.MongoConfig;

@EnableMongoRepositories(basePackages = "ru.otus.dz12.repository")
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Main.class, args);
    }
}
