package com.crud.backend.controller;


import com.crud.backend.entity.Customer;
import com.crud.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Post
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    //List
    @GetMapping("/customers")
    private List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    //List Id
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    //Update
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updateCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    //Deletar

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
