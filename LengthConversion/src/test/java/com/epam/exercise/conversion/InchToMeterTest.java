package com.epam.exercise.conversion;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This is a test class.
 * @author Manasa_Maddali
 *
 */
public class InchToMeterTest {
/**
 * This method is used to test conversion method in InchToMeter class.
 */
	
	@Test
	public void test() {
		InchToMeter im=new InchToMeter();
		double expectedValue=im.conversion(12);
		double actualValue=3.048;
		assertEquals(actualValue,expectedValue,0.0);
		expectedValue=im.conversion(25);
		actualValue=6.35;
		assertEquals(actualValue,expectedValue,0.0);
	}

}
