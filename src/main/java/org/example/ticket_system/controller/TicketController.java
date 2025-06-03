package org.example.ticket_system.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.ticket_system.model.TicketEntity;
import org.example.ticket_system.model.response.TicketResponse;
import org.example.ticket_system.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    @PostMapping
    public TicketResponse addTicket(){
        return ticketService.addTicket();
    }

    @GetMapping
    public TicketResponse getCurrentTicket(){
        return ticketService.getCurrentWaitingTicket();
    }

    @DeleteMapping
    public TicketResponse deleteCurrentTicket(){
        return ticketService.deleteCurrentWaitingTicket();
    }
}
