package webalapu.service;

import webalapu.model.Ticket;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TicketManagerLocal {
    List<Ticket> getAllTicket();
}
