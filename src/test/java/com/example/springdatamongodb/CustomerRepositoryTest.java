package com.example.springdatamongodb;

import com.example.springdatamongodb.entity.Customer;
import com.example.springdatamongodb.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class CustomerRepositoryTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @Autowired
    private CustomerRepository customerRepository;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @AfterEach
    void cleanUp() {
        this.customerRepository.deleteAll();
    }

    @Test
    void shouldReturnListOfCustomers() {
        this.customerRepository.save(new Customer("Davi", "Mustafa"));
        this.customerRepository.save(new Customer("MyFirstName", "MyLastName"));

        List<Customer> customers = customerRepository.findAll();

        assertEquals(2, customers.size());
    }

    @Test
    void shouldReturnUserGivenFirstName() {
        this.customerRepository.save(new Customer("Davi", "Mustafa"));
        this.customerRepository.save(new Customer("MyFirstName", "MyLastName"));

        Customer customer = customerRepository.findByFirstName("Davi");

        assertNotNull(customer);
    }
}
