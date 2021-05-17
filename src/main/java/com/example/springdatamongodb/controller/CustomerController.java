package com.example.springdatamongodb.controller;

import com.example.springdatamongodb.entity.Customer;
import com.example.springdatamongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/byFirstName")
    public ResponseEntity<?> getByFirstName(@RequestParam String firstName) {
        Customer customer = repository.findByFirstName(firstName);
        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/byLastName")
    public ResponseEntity<?> getByLastName(@RequestParam String lastName) {
        List<Customer> all = repository.findByLastName(lastName);
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        repository.save(customer);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable String id,
                                    @RequestBody Customer customer) {

        Optional<Customer> result = repository.findById(id);

        if(result.isPresent()){
            result.get().setFirstName(customer.getFirstName());
            result.get().setLastName(customer.getLastName());
            repository.save(result.get());
        }

        return ResponseEntity.ok().build();
    }
}
