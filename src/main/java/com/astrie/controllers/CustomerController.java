package com.astrie.controllers;


import com.astrie.model.Customer;
import com.astrie.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8060/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/api/v1/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();

    }
}
