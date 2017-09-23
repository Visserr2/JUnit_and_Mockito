package nl.tutorial.useradmin.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import nl.tutorial.useradmin.dto.User;
import nl.tutorial.useradmin.util.IdGenerator;

/** Mockito cannot mock:
 * - Static methods
 * - Final methods
 * - Constructors
 * - Private methods
 * - Enums
 * 
 * The methods for PowerMock are the same as Mockito: when, thenReturn, verify, etc.
 * To use PowerMock the class must be annoted with @RunWith(PowerMockRunner.class) and @PrepareForTest(ClassThatNeedToBeMocked.Class)
 * An old version of mockito must be used: 23-09-2017 : Mockito - 1.10.19
 * 
 * To verify first call the verifyStatic-method and then write the method you want to verify - See below
 * 
 * @author ronald
 */

// Run with PowerMockRunner And Mock class IdGenerator
@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class UserDaoTest {
	
	private UserDao userDao;
	
    @Before
    public void setup() {
        userDao = new UserDao();
    }

	@Test
	public void createShouldReturnAUserId() {
				
		// Mock static methods of IdGenerator
		mockStatic(IdGenerator.class);
		// When generateId-method is called, return 1
		when(IdGenerator.generateID()).thenReturn(1);
		
		int result = userDao.create(new User());
		
		// Verify if staticMethod is run
		// 1. Call verifyStatic-method and specify how much the static method should have been run
		verifyStatic(IdGenerator.class, times(1));
		// 2. Write the static-method that need to be verified. The method-invocation below doesn't count in te verification process
		IdGenerator.generateID();
		
		
		assertSame(1, result);
		
	}

}
