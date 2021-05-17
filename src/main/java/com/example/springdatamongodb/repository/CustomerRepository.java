package com.example.springdatamongodb.repository;

import com.example.springdatamongodb.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    @Query(value ="{'lastName' : ?0}", fields = "{'id' : 0}")
    List<Customer> findByLastName(String lastName);
}
