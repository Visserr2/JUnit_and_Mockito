package nl.tutorial.order.exception;

import java.sql.SQLException;

public class BOException extends Exception {

	private static final long serialVersionUID = 9183882254632228440L;

	public BOException(SQLException e) {
		super(e);
	}
	
	
}
