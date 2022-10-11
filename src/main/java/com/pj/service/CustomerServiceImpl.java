package com.pj.service;

import com.pj.model.Customer;
import com.pj.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class that handles business logic to get, create, update Customers
 *
 * @author Pavan Kumar Jadda
 * @since 2.0.0
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
        return customerRepository.findByFirstName(firstName);
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
        return customerRepository.findByLastName(lastName);
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
        return customerRepository.insert(customer);
    }
}
