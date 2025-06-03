package org.example.ticket_system.service;

import lombok.AllArgsConstructor;
import org.example.ticket_system.controller.exception.ApiException;
import org.example.ticket_system.model.TicketEntity;
import org.example.ticket_system.model.response.TicketResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private QueueService queueService;

    public TicketResponse addTicket(){
        return queueService.addToQueue();
    }

    public TicketResponse getCurrentWaitingTicket(){
        TicketResponse ticketResponse = queueService.getFromQueue();
        if (ticketResponse == null){
            throw new ApiException(HttpStatus.NOT_FOUND, "No tickets in queue");
        }
        return ticketResponse;
    }

    public TicketResponse deleteCurrentWaitingTicket(){
        TicketResponse ticketResponse = queueService.pollFromQueue();
        if (ticketResponse == null){
            throw new ApiException(HttpStatus.NOT_FOUND, "No tickets in queue");
        }
        return ticketResponse;
    }
}
