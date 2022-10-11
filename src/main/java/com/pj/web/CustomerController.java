package com.pj.web;

import com.pj.model.Customer;
import com.pj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Provides API endpoints for Customer operations
 *
 * @author Pavan Kumar Jadda
 * @since 2.1.0
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
    @GetMapping("/find/first_name/{firstName}")
    public ResponseEntity<Customer> findByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(customerService.findByFirstName(firstName));
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
    @GetMapping("/find/last_name/{lastName}")
    public ResponseEntity<List<Customer>> findByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(customerService.findByLastName(lastName));
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
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.insert(customer));
    }
}

