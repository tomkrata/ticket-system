package org.example.ticket_system.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AbstractEntity {
    private long id;
    private LocalDateTime creationDate;
}
