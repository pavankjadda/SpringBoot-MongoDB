package com.pj.service;

import com.pj.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

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
    Optional<Customer> getById(String id);

    /**
     * Find all customers
     *
     * @return List of all customers
     *
     * @author Pavan Kumar Jadda
     * @since 2.1.0
     */
    List<Customer> findAll();

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
    Customer findByFirstName(String firstName);

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
    List<Customer> findByLastName(String lastName);

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
    Customer insert(Customer customer);

    /**
     * Update the customer
     *
     * @param customer an object that contains updated customer information
     *
     * @return Updated customer
     *
     * @author Pavan Kumar Jadda
     * @since 3.0.0
     */
    Customer updateCustomer(Customer customer);

    /**
     * Delete customer by ID
     *
     * @param id ID of the customer that needs to be deleted
     *
     * @author Pavan Kumar Jadda
     * @since 3.0.0
     */
    void deleteById(String id);
}