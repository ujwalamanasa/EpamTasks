package com.epam.exercise.conversion;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This is a test class.
 * @author Manasa_Maddali
 *
 */
public class InchToFeetTest {
/**
 * This method is used to test conversion method in InchToFeet class.
 */
	@Test
	public void test() {
		InchToFeet itf=new InchToFeet();
		double expectedValue=itf.conversion(12);
		double actualValue=1.00008;
		assertEquals(actualValue,expectedValue,0.0);
		expectedValue=itf.conversion(25);
		actualValue=2.0835;
		assertEquals(actualValue,expectedValue,0.0);
	}

}
