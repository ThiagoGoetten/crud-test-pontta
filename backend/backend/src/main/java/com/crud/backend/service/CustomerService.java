package com.crud.backend.service;


import com.crud.backend.entity.Customer;
import com.crud.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Post
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //List
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //List Id
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElse(null);
    }

    //Update
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //Delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
