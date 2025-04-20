package com.pj.web;

import com.pj.model.Customer;
import com.pj.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Provides API endpoints for Customer operations
 *
 * @author Pavan Kumar Jadda
 * @since 2.1.0
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /**
     * Find all customers
     *
     * @return List of all customers
     *
     * @author Pavan Kumar Jadda
     * @since 3.0.0
     */
    @GetMapping("/find/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(service.findAll());
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
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Customer>> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
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
        return ResponseEntity.ok(service.findByFirstName(firstName));
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
        return ResponseEntity.ok(service.findByLastName(lastName));
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
        return ResponseEntity.ok(service.insert(customer));
    }
}