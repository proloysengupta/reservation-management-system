package com.proloy.micro.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping("/test")
    public String test() {
        return "Notification Service Working!";
    }

    @GetMapping("/send")
    public String send() {
        return "Notification Sent!";
    }
}
