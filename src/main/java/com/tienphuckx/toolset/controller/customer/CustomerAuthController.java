package com.tienphuckx.toolset.controller.customer;

import com.tienphuckx.toolset.entity.customer.Customer;
import com.tienphuckx.toolset.service.auth.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/register")
public class CustomerAuthController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm(@RequestBody Customer customer) {
        return "register"; //redirect to home page after register successfully
    }

    @PostMapping("/customer-login")
    public String registerCustomer(@RequestBody Customer customer) {
//        customerService.(customer);
        return "redirect:/login"; // Redirect to login after successful registration
    }
}
