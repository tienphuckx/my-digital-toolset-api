package com.tienphuckx.toolset.service.auth;

import com.tienphuckx.toolset.entity.customer.Customer;

public interface CustomerService {
    public Customer getCustomer(String customerId);

    Customer findByUsername(String username);
}
