package org.example.ticket_system.service;

import lombok.AllArgsConstructor;
import org.example.ticket_system.model.TicketEntity;
import org.example.ticket_system.model.response.TicketResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private QueueService queueService;

    public TicketResponse addTicket(){
        return queueService.addToQueue();
    }

    public TicketResponse getCurrentWaitingTicket(){
        return queueService.getFromQueue();
    }

    public TicketResponse deleteCurrentWaitingTicket(){
        return queueService.pollFromQueue();
    }
}
