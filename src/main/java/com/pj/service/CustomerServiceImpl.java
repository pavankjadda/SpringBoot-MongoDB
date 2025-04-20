package com.pj.service;

import com.pj.model.Customer;
import com.pj.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic to get, create, update Customers
 *
 * @author Pavan Kumar Jadda
 * @since 2.0.0
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    /**
     * Find the customer by ID
     *
     * @param id ID of the customer that needs to be found
     *
     * @return Customer matching the given ID
     *
     * @author Pavan Kumar Jadda
     * @since 3.0.0
     */
    @Override
    public Optional<Customer> getById(String id) {
        return repository.findById(id);
    }

    /**
     * Find all customers
     *
     * @return List of all customers
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    /**
     * Find the customer by first Name
     *
     * @param firstName The first name of the customer to be found
     *
     * @return Customer matching the given firstName
     *
     * @author Pavan Kumar Jadda
     * @since 2.0.0
     */
    @Override
    public Customer findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    /**
     * Find the customer by last Name
     *
     * @param lastName The last name of the customer to be found
     *
     * @return Customer matching the given lastName
     *
     * @author Pavan Kumar Jadda
     * @since 2.0.0
     */
    @Override
    public List<Customer> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    /**
     * Save the customer information.
     *
     * @param customer an object that contains new/updated customer information
     *
     * @return Updated customer object
     *
     * @author Pavan Kumar Jadda
     * @since 2.0.0
     */
    @Override
    public Customer insert(Customer customer) {
        return repository.insert(customer);
    }
}