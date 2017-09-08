package nl.tutorial.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsNull() {
		String result = greeting.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsBlank() {
		String result = greeting.greet("");
	}
	
	@After
	public void teardown(){
		greeting = null;
	}

}
