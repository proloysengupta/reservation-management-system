package com.example.reservationservice.service;

import com.example.reservationservice.config.RabbitConfig;
import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.repository.ReservationRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

	public Reservation addReservation(Reservation reservation) {
		Reservation saved = repository.save(reservation);
		rabbitTemplate.convertAndSend("reservation.queue", "Reservation created for: " + saved.getCustomerName());
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, saved.getCustomerName());
		return saved;
	}

    public List<Reservation> getAll() {
        return repository.findAll();
    }
}
