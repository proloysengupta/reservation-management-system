package com.proloy.micro.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "reservation.queue")
    public void receiveMessage(String message) {
        System.out.println("Notification Received: " + message);
    }
}