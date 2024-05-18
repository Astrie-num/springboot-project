package com.astrie.services;

import com.astrie.model.Customer;
import com.astrie.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired

    private CustomerRepository customerRepository;
    private  CustomerService customerService;


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
