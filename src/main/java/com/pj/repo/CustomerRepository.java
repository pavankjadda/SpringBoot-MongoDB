package com.pj.repo;

import java.util.List;

import com.pj.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>
{
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
