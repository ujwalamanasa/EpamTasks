package com.epam.exercise.conversion;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This is a test class.
 * @author Manasa_Maddali
 *
 */
public class FeetToInchTest {
	/**
	 * This method is used to test conversion method in FeetToInch class.
	 */
	@Test
	public void test() {
		FeetToInch fi=new FeetToInch();
		double expectedValue=fi.conversion(15);
		double actualValue=180.0;
		assertEquals(actualValue,expectedValue,0.0);
		expectedValue=fi.conversion(50);
		actualValue=600.0;
		assertEquals(actualValue,expectedValue,0.0);
	}

	

}
