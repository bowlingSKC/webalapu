package webalapu.service;

import webalapu.model.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TicketManager implements TicketManagerLocal {
    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    @Override
    public List<Ticket> getAllTicket() {
        Query query = em.createQuery("SELECT ticket FROM Ticket ticket", Ticket.class);
        List<Ticket> tickets = query.getResultList();
        if(tickets == null) {
            new ArrayList<Ticket>();
        }
        return tickets;
    }

}
