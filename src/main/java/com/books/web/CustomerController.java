package com.books.web;

import com.books.model.Customer;
import com.books.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService   customerService)
    {
        this.customerService=customerService;
    }

    @PostMapping("/customers/save_customer")
    public ResponseEntity<Customer> saveBook(@RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.insert(customer));
    }

    @GetMapping("/customers/{firstName}")
    public ResponseEntity<Customer> findByFirstName(@PathVariable    String  firstName)
    {
        return ResponseEntity.ok(customerService.findByFirstName(firstName));
    }

    @GetMapping("/customers/{lastName}")
    public ResponseEntity<List<Customer>> findByLastName(@PathVariable    String  lastName)
    {
        return ResponseEntity.ok(customerService.findByLastName(lastName));
    }
}

