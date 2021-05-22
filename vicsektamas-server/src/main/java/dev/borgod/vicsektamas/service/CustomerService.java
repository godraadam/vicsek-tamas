package dev.borgod.vicsektamas.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.model.Customer;
import dev.borgod.vicsektamas.model.Role;
import dev.borgod.vicsektamas.repo.CustomerRepo;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private UserService userService;

    public Customer registerCustomer(Customer customerToRegister) {
        var customer = (Customer) userService.registerUser(customerToRegister);
        if (customer == null) return null;
        customer.setRole(Role.CUSTOMER);
        customer.setReservations(Collections.emptyList());
        return customer;
    }

    

}
