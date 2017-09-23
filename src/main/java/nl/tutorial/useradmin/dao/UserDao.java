package nl.tutorial.useradmin.dao;

import nl.tutorial.useradmin.dto.User;
import nl.tutorial.useradmin.util.IdGenerator;

public class UserDao {
	
	public int create(User user) {
		int id = IdGenerator.generateID();
		// save user to database
		return id;
	}
}
