package com.pj.service;

import com.pj.model.Customer;

import java.util.List;

public interface CustomerService {
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
}
