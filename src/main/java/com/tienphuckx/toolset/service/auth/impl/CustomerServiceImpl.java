package com.tienphuckx.toolset.service.auth.impl;

import com.tienphuckx.toolset.entity.customer.Customer;
import com.tienphuckx.toolset.repository.CustomerRepository;
import com.tienphuckx.toolset.service.auth.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getCustomer(String customerId) {
        return new Customer();
    }

    @Override
    public Customer findByUsername(String username) {
        return null;
    }
}
