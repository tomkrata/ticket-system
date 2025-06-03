package org.example.ticket_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public record TicketEntity(long id, LocalDateTime creationDate) {}
