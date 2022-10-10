package com.pj.service;

import com.pj.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    Customer insert(Customer customer);
}
