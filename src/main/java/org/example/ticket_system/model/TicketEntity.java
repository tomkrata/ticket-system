package org.example.ticket_system.model;


import java.time.LocalDateTime;


public record TicketEntity(long id, LocalDateTime creationDate) {}
