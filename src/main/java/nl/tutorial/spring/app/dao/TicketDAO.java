package nl.tutorial.spring.app.dao;

import nl.tutorial.spring.app.dto.Ticket;

public interface TicketDAO {
	
	int createTicket(Ticket ticket);
}
