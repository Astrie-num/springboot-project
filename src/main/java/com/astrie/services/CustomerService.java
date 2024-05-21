package com.astrie.services;

import com.astrie.model.Customer;
import com.astrie.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired

    private CustomerRepository customerRepository;
    private  CustomerService customerService;


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

//    public void deleteCustomer(Customer customer) {
//        customerRepository.delete(customer);
//    }

    public void update(Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(updatedCustomer.getId());

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setAge(updatedCustomer.getAge());

            customerRepository.save(existingCustomer);
        }
        else {
            throw new RuntimeException("Customer not found with id " + updatedCustomer.getId());
        }
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteAllById(Collections.singleton(id));
    }
}
