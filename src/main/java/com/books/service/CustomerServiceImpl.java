package com.books.service;

import com.books.model.Customer;
import com.books.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    private CustomerRepository  customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository   customerRepository)
    {
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer findByFirstName(String firstName)
    {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Customer> findByLastName(String lastName)
    {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public Customer insert(Customer customer)
    {
        return customerRepository.insert(customer);
    }
}
