package org.swe_group.ice_tracker.trouble_ticket_management;

import java.sql.Date;

@lombok.Getter
public class TroubleTicket {
    private String ticketNumber;
    private Date reportDate;
    private String description;
    private TicketStatus status;
    private String resolution;

    public void updateStatus(TicketStatus newStatus) {
        this.status = newStatus;
    }

    public void addResolution(String resolution) {
        this.resolution = resolution;
        this.status = TicketStatus.CLOSED;
    }

    // Constructor, getters, and setters
}
