package nl.tutorial.spring.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import nl.tutorial.spring.app.dao.TicketDAO;
import nl.tutorial.spring.app.dto.Ticket;

/** Spring Test
 * To use Spring for testing the Test should be run with @RunWith(SpringJUnit4ClassRunner.class)
 * After that the beans.xmls should be imported for the Spring-context. Use @ContextConfiguration(locations="beans.xml") for this
 * Use the @Autowired for autowiring the beans in the test. The @InjectMocks is used to inject the mocked-object into the object that need to be autowired
 * In this case TicketServiceImpl need to autowire the TicketDao. We need to tell the TicketService-Object that it needs to autowire the Mocked TicketDao.
 * @author ronald
 *
 *
 *Update: updated to Spring 5. Also use @ExtendWith(SpringExtension.class) instead of @RunWith(SpringJUnit4ClassRunner.class)
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int EXPECTED_RESULT = 1;
	private static final String PASSENGER_NAME = "Ronald";
	private static final String PASSENGER_PHONE = "1234567890";
	
	@Mock
	TicketDAO dao;
	@Autowired
	@InjectMocks
	private TicketService service;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buyTicketsShouldReturnsAValidValue() {
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		
		int result = service.buyTicket(PASSENGER_NAME, PASSENGER_PHONE);
		
		verify(dao, times(1)).createTicket(any(Ticket.class));
		assertEquals(EXPECTED_RESULT, result);
	}

}
