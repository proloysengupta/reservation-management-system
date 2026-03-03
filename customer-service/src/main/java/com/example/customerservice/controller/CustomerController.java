package com.example.customerservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/test")
    public String test(){
        return "Customer Service Working!";
    }

    @PostMapping("/add")
    public String addCustomer(){
        return "Customer Added Successfully!";
    }
}
