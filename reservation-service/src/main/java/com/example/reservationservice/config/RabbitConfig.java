package com.example.reservationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "reservation.queue";
    public static final String EXCHANGE = "reservation.exchange";
    public static final String ROUTING_KEY = "reservation.routingkey";

    @Bean
    public Queue reservationQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange reservationExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue reservationQueue, DirectExchange reservationExchange) {
        return BindingBuilder
                .bind(reservationQueue)
                .to(reservationExchange)
                .with(ROUTING_KEY);
    }
}