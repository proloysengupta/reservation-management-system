package com.example.reservationservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import com.example.reservationservice.service.ReservationService;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    public ReservationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveReservation() {

        Reservation reservation = new Reservation(null,"Proloy","Taj");

        when(reservationRepository.save(any(Reservation.class)))
                .thenReturn(reservation);

        Reservation saved = reservationService.addReservation(reservation);

        assertNotNull(saved);
        assertEquals("Proloy", saved.getCustomerName());
    }
}
