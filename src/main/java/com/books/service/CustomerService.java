package com.books.service;

import com.books.model.Customer;

import java.util.List;

public interface CustomerService
{
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    Customer    insert(Customer customer);
}
