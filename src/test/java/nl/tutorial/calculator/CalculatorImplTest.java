package nl.tutorial.calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Make use of parameterized tests. The steps to do this are: 
 * 1. Identify input data and results 
 * 2. Create fields for the input data and results 
 * 3. Create a constructor to assign the created fields in the test class 
 * 4. Create a static methods, this will be marked with @Parameters
 * 5. Create or Update the Test Method
 * 6. Mark Class with @RunWith(Parameterized.class)
 * 
 * A Class annotated with the Parameterized.class will invoke the static method with @Parameters that will return a Collection-Object as dataset.
 * Then it will execute the class with the provided dataset.
 * @author ronald
 */
@RunWith(Parameterized.class)
public class CalculatorImplTest {

	private int num1;
	private int num2;
	private int expectedResult;

	public CalculatorImplTest(int num1, int num2, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = result;
	}

	@Parameters
	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { -1, 2, 1 }, { 1, 2, 3 }, { 6, 7, 13 } });
	}

	@Test
	public void addShouldReturnAResult() {
		Calculator c = new CalculatorImpl();
		int result = c.add(num1, num2);

		assertEquals(expectedResult, result);
	}
}
