package com.example.tickets;

import java.util.Arrays;

/**
 * Service layer that creates and "updates" tickets.
 * Refactored to stop mutating existing instances and instead return new ones.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // Validation now safely resides inside the Builder's build() method!
        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(Arrays.asList("NEW"))
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // Return a fresh copy with updated values using toBuilder()
        return t.toBuilder()
                .priority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // Return a fresh copy safely validated during build()
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
