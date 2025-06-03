package org.example.ticket_system.service;

import org.example.ticket_system.model.TicketEntity;
import org.example.ticket_system.model.response.TicketResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class QueueService {

    private final Queue<TicketEntity> queue = new ConcurrentLinkedQueue<>();
    private int totalTicketsCreated = 0;
    public synchronized TicketResponse addToQueue() {
        TicketEntity ticketEntity = new TicketEntity(
                ++totalTicketsCreated,
                LocalDateTime.now()
        );
        int queueSize = queue.size();
        queue.add(ticketEntity);
        return new TicketResponse(ticketEntity.id(), ticketEntity.creationDate(), queueSize);
    }
    public TicketResponse getFromQueue() {
        if (queue.isEmpty()) {
            return null;
        }
        TicketEntity ticketEntity = queue.peek();
        return new TicketResponse(ticketEntity.id(), ticketEntity.creationDate(), 0);
    }

    public synchronized TicketResponse pollFromQueue() {
        if (queue.isEmpty()) {
            return null;
        }
        TicketEntity ticketEntity = queue.poll();
        return new TicketResponse(ticketEntity.id(), ticketEntity.creationDate(), 0);
    }
}
