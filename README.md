# Reservation Management System

## Project Overview

This project implements a Microservices-based Reservation Management
System using Spring Boot.

## Microservices

-   Customer Service
-   Reservation Service
-   Payment Service
-   Hotel Management Service
-   Notification Service
-   Service Discovery (Eureka)
-   API Gateway

## Technologies Used

-   Java 17
-   Spring Boot
-   Spring Cloud (Eureka, Gateway, OpenFeign)
-   Resilience4j (Circuit Breaker)
-   RabbitMQ (Asynchronous Communication)
-   MySQL (Database per Service)
-   Docker & Docker Compose
-   Kubernetes (Minikube)
-   Jenkins (CI/CD)

## How to Run Using Docker

1.  Start Docker Desktop.
2.  Navigate to project root folder.
3.  Run: docker compose up --build
4.  Access services:
    -   Eureka: http://localhost:8761
    -   API Gateway: http://localhost:8080
    -   RabbitMQ: http://localhost:15672
    -   Jenkins: http://localhost:9090

## Sample API Endpoints

-   Add Reservation: POST http://localhost:8080/reservation/add

-   Get All Reservations: GET http://localhost:8080/reservation/all

-   Book Reservation (Sync + Circuit Breaker): GET
    http://localhost:8080/reservation/book

## Asynchronous Flow

Reservation Service → RabbitMQ → Notification Service

## CI/CD

Jenkins pipeline builds the project and verifies Maven build.

## Observability

Spring Boot Actuator enabled: GET /actuator/health

------------------------------------------------------------------------

Developed as part of Microservices Architecture Implementation.
