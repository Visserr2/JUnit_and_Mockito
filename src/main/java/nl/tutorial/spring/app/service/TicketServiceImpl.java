package nl.tutorial.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.tutorial.spring.app.dao.TicketDAO;
import nl.tutorial.spring.app.dto.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO dao;
	
	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int buyTicket(String passengerName, String phone) {
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		return dao.createTicket(ticket);
	}

}
