package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/test")
    public String test() {
        return "Payment Service Working!";
    }

    @GetMapping("/pay")
    public String pay() {
        return "Payment Successful!";
    }
}