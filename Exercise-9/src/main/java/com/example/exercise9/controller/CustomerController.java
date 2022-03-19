package com.example.exercise9.controller;

import com.example.exercise9.model.Customer;
import com.example.exercise9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer createCustomer(@RequestParam("code") Long code,
                                   @RequestParam("fullName") String fullName) {
       return customerService.createCustomer(code, fullName);
    }

    @PostMapping("/edit")
    public Customer editCustomer(@RequestBody Customer customer) {
       return customerService.editCustomer(
               customer.getId(),
               customer.getCode(),
               customer.getFullName());
    }

    @PostMapping("/delete")
    public void deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/show")
    public Customer showCustomer(@RequestParam("id") Long id) {
        return customerService.showCustomer(id);
    }

    @GetMapping("/show-all")
    public List<Customer> showAllCustomers() {
        return customerService.showAllCustomers();
    }
}
