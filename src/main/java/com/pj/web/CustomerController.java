package com.pj.web;

import com.pj.model.Customer;
import com.pj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/find/first_name/{firstName}")
    public ResponseEntity<Customer> findByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(customerService.findByFirstName(firstName));
    }

    @GetMapping("/find/last_name/{lastName}")
    public ResponseEntity<List<Customer>> findByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(customerService.findByLastName(lastName));
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveBook(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.insert(customer));
    }
}

