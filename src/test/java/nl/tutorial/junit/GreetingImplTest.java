package nl.tutorial.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Unit Test should be F.I.R.S.T
 * F - Fast
 * I - Independent - Methods should not depend on each other
 * R - Repeatable - On all environments
 * S - Self-Validating - Tests have boolean (succes, fail) result
 * T - Timely - Write tests before writing code or directly after
 * @author ronald
 */

/** Update 29-08-2018
 *  Use Junit 5 instead of 4
 *  Changes:
 *  	- @Before = @BeforeEach
 *  	- @After = @AfterEach
 *  	- New static imports:  org.junit.jupiter.api.Assertions.* for new assertions
 *  	- New @Test annotation in package org.junit.jupiter.api.Test
 *  	- Expected attribute no longer supported. Use Assertion Class
 * @author visserr2
 *
 */
public class GreetingImplTest {
	
	private Greeting greeting;
	
	// Runs before each test method
	@BeforeEach
	public void setup() {
		greeting =  new GreetingImpl();
	}

	@Test
	public void greetShouldReturnValidOutput() {
		String result = greeting.greet("Ronald");	
		assertNotNull(result);
		assertEquals("Hello Ronald", result);
	}
	
	// JUNIT 4
/*	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsNull() {
		String result = greeting.greet(null);
	}*/
	
	// JUNIT5
	@SuppressWarnings("unused")
	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			String result = greeting.greet(null);
		});
	}
	
	@SuppressWarnings("unused")
	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {	
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			String result = greeting.greet("");
		});
	}
	
	// Runs after each test method
	@AfterEach
	public void teardown(){
		greeting = null;
	}

}
