package org.example.ticket_system.model.response;

import java.time.LocalDateTime;

public record TicketResponse(long id, LocalDateTime creationDate, long orderId) {}
