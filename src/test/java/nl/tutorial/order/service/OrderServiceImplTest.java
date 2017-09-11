package nl.tutorial.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nl.tutorial.order.dao.OrderDAO;
import nl.tutorial.order.dto.Order;
import nl.tutorial.order.exception.BOException;

public class OrderServiceImplTest {
	
	@Mock
	private OrderDAO dao;
	private OrderServiceImpl service;
	private Order order;
	
	@Before
	public void setup() {
		// Initialize mocks
		MockitoAnnotations.initMocks(this);	
		service = new OrderServiceImpl();
		order = new Order();
		service.setDao(dao);
	}

	@Test
	public void placeOrder_Should_Create_Order() throws SQLException, BOException{	
		// Setting Expectation
		when(dao.create(order)).thenReturn(new Integer(1));			
		boolean result = service.placeOrder(order);
		
		// verify the result
		//1. Check if dao.create gets called once or more
		verify(dao).create(order);
		
		//2. Check if the result is true
		assertTrue(result);
	}
	
	@Test
	public void placeOrder_Should_Not_Create_Order() throws SQLException, BOException{			
		// Setting Expectation
		when(dao.create(order)).thenReturn(new Integer(0));			
		boolean result = service.placeOrder(order);
		
		// verify the result
		//1. Check if dao.create gets called once or more
		verify(dao).create(order);
		
		//2. Check if the result is false
		assertFalse(result);
	}
	
	@Test(expected=BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException{			
		// Setting Expectation - throws SQL Exception
		when(dao.create(order)).thenThrow(SQLException.class);			
		service.placeOrder(order);
	}
	
	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		// setting expectations
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);		
		
		// execute methods
		boolean result = service.candelOrder(123);
		
		// verify if methods are called
		verify(dao).read(123);
		verify(dao).update(order);
		
		// assert result
		assertTrue(result);
	}
	
	@Test
	public void cancelOrder_Should_Not_Cancel_The_Order() throws SQLException, BOException {
		// setting expectations
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);		
		
		// execute methods
		boolean result = service.candelOrder(123);
		
		// verify if methods are called
		verify(dao).read(123);
		verify(dao).update(order);
		
		// assert result
		assertFalse(result);
	}
	
	@Test(expected=BOException.class)
	public void cancelOrder_ReadMethod_Should_Throw_BOException() throws SQLException, BOException {
		// setting expectations
		when(dao.read(123)).thenThrow(SQLException.class);
		
		// execute methods
		service.candelOrder(123);	
	}
	
	@Test(expected=BOException.class)
	public void cancelOrder_UpdateMethod_Should_Throw_BOException() throws SQLException, BOException {
		// setting expectations
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		
		// execute methods
		service.candelOrder(123);	
	}
	
	

}
