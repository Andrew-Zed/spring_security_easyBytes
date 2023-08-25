package com.andrew.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ContactController {

    @GetMapping("/contacts")
    public String saveContactInquiryDetails() {
        return "Inquiry details are saved to the DB";
    }

}
