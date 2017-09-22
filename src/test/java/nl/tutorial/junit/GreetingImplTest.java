package nl.tutorial.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Unit Test should be F.I.R.S.T
 * F - Fast
 * I - Independent - Methods should not depend on each other
 * R - Repeatable - On all environments
 * S - Self-Validating - Tests have boolean (succes, fail) result
 * T - Timely - Write tests before writing code or directly after
 * @author ronald
 */
public class GreetingImplTest {
	
	private Greeting greeting;
	
	@Before
	public void setup() {
		greeting =  new GreetingImpl();
	}

	@Test
	public void greetShouldReturnValidOutput() {
		String result = greeting.greet("Ronald");
		
		assertNotNull(result);
		assertEquals("Hello Ronald", result);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsNull() {
		String result = greeting.greet(null);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsBlank() {
		String result = greeting.greet("");
	}
	
	@After
	public void teardown(){
		greeting = null;
	}

}
