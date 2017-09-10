package nl.tutorial.order.service;

import nl.tutorial.order.dto.Order;
import nl.tutorial.order.exception.BOException;

public interface OrderService {
	
	boolean placeOrder(Order order) throws BOException;
	
	boolean candelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;
}
