package com.example.springdatamongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.example.springdatamongodb.repository"})
@SpringBootApplication
public class SpringDataMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongoDbApplication.class, args);
    }

}
