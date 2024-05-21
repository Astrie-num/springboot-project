package com.astrie.controllers;


import com.astrie.model.Customer;
import com.astrie.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "http://localhost:8060")

public class CustomerController {
    @Autowired
    private CustomerService customerService;



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerService.findAll();

    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> RegisterCustomer(@RequestBody Customer customer) {
        try{
            customerService.addCustomer(customer);
            return ResponseEntity.ok("Customer added successfully");
        }
        catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());

        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        try{
            customerService.deleteCustomerById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        try {
            customer.setId(id);
            customerService.update(customer);
            return ResponseEntity.ok("Customer updated successfully");
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
