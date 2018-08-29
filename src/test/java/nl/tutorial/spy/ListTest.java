package nl.tutorial.spy;


import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/** Difference Spy and Mocks
 *  Spy is partial mocking. The real objects is used and real methods will be called unless the method is mocked.
 *  There are two different ways for partial mocking. 
 *  1. Using Spy-annotation and mock the methods that need to be mocked. All other methods are the real methods of the object
 *  2. Using Mock-annotation. If a real method need to be called 
 *  Second way is preferred. Only use real methods if necessary, else mock out the method. 
 * @author ronald
 *
 */
public class ListTest {

	@Spy
	List<String> myList = new ArrayList<>();
	
	@Mock
	ArrayList<String> myList2 = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void spyAnnotationTest() {
		// Calling real add method
		myList.add("Ronald");
		myList.add("Jeroen");
		
		// Mocking size-method via Mockito-object with Spy-annotation
		Mockito.doReturn(3).when(myList).size();
		assertSame(3, myList.size());
	}
	
	@Test
	public void mockAnnotationTest() {
		// This doesn't add because mock-annotation doesn't use real methods
		myList2.add("Ronald");
		myList2.add("Jeroen");
		myList2.add("Jeroen");
		
		// Call real method with Mock-Object. Preferred over the Spy-annotation style
		//	when(myList2.size()).thenCallRealMethod();
		
		when(myList2.size()).thenReturn(3);
		
		assertSame(3, myList2.size());
	}

}
