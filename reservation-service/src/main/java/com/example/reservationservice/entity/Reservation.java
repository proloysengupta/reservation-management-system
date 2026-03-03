package com.example.reservationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String hotelName;

    public Reservation() {}

    public Reservation(Long id, String customerName, String hotelName) {
        this.id = id;
        this.customerName = customerName;
        this.hotelName = hotelName;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getHotelName() {
        return hotelName;
    }
}