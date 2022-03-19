package com.example.exercise9.service;

import com.example.exercise9.model.Customer;
import com.example.exercise9.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Long code, String fullName) {
        Customer customer = new Customer();
        customer.setCode(code);
        customer.setFullName(fullName);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = findCustomerById(id);
        customerRepository.delete(customer);
    }

    public Customer editCustomer(Long id, Long code, String fullName) {
        Customer customer = findCustomerById(id);
        customer.setCode(code);
        customer.setFullName(fullName);
        return customerRepository.save(customer);
    }

    public Customer showCustomer(Long id) {
        return findCustomerById(id);
    }

    public List<Customer> showAllCustomers() {
        return customerRepository.findAll();
    }

    private Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer: " + id + " not found!"));
    }
}
