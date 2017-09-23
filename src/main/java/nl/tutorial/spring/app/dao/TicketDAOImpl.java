package nl.tutorial.spring.app.dao;

import org.springframework.stereotype.Repository;

import nl.tutorial.spring.app.dto.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	@Override
	public int createTicket(Ticket ticket) {
		return 1;
	}

}
