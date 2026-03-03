package com.proloy.micro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @GetMapping("/test")
    public String test(){
        return "Hotel Service Working!";
    }

    @PostMapping("/add")
    public String addHotel(){
        return "Hotel Added Successfully!";
    }
}