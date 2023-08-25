package com.andrew.springsecurity.controller;

import com.andrew.springsecurity.model.Customer;
import com.andrew.springsecurity.repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private CustomerRepositories customerRepositories;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity<String> response = null;

        try {
            String hashedPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPwd);
            savedCustomer = customerRepositories.save(customer);
            if (savedCustomer.getId() > 0) {
              response = ResponseEntity
                      .status(HttpStatus.CREATED)
                      .body("Given user details are successfully registered");
        }

    } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An Exception occurred due to " + ex.getMessage());
        }
        return response;
    }

}
