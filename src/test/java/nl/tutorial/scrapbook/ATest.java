package nl.tutorial.scrapbook;


import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** TEST DOUBLES - Generic term for test-objects and procedures. 5 common test doubles are:
 *  Dummy - The objects passed as parameter but are not requiered for testing
 *  Stub - Objects that returns fixed answers and return values (when-then).
 *  Mock - Stubs that can also throw exceptions and verify methods
 *  Fake - Fake data like in memory databases
 *  Spies - Stubs that can spy or record side effects when executing tests
 * @author ronald
 *
 */
public class ATest {
	
	@Mock
	B b;
	private A a;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@Test
	public void usesVoidMethodShouldCallTheVoidMethod() throws Exception {
		// Run void method explicitly
		doNothing().when(b).voidMethod();
		
		// Run void method automatically because B is mocked. If a class is mocked all void methods are automatically mocked.
		assertSame(1, a.usesVoidMethod());
		
		// The method still runs one time
		verify(b, times(1)).voidMethod();

	}
	
	@Test
	public void usesVoidMethodShouldThrowRuntimeException() throws Exception {
		// Run void method and throw exception
		doThrow(Exception.class).when(b).voidMethod();
		
		Assertions.assertThrows(RuntimeException.class, ()->{
			a.usesVoidMethod();
		});
	}
	
	@Test
	public void usesVoidMethodShouldTestTwoCalls() throws Exception {
		// When voidMethod is called. First Do Nothing, Second Throw Exception
		doNothing().doThrow(Exception.class).when(b).voidMethod();
		
		// Call method first time
		assertSame(1, a.usesVoidMethod());
		verify(b, times(1)).voidMethod();
		
		// call method second time, throw exception
		Assertions.assertThrows(RuntimeException.class, ()->{
			a.usesVoidMethod();
		});
	}

}
