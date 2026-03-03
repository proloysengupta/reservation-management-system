package com.example.reservationservice.controller;

import com.example.reservationservice.client.NotificationClient;
import com.example.reservationservice.client.PaymentClient;
import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.service.ReservationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    
    @Autowired
    private PaymentClient paymentClient;
    
    @Autowired
    private NotificationClient notificationClient;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public Reservation add(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }
    
    @GetMapping("/book")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public String bookReservation() throws Exception {

        String paymentResponse = paymentClient.makePayment();

        String notificationResponse = notificationClient.sendNotification();

        return "Reservation Booked + " 
                + paymentResponse 
                + " + " 
                + notificationResponse;
    }
    
    public String paymentFallback(Throwable ex) {
        return "Payment Service DOWN - Reservation saved without payment!";
    }
}
