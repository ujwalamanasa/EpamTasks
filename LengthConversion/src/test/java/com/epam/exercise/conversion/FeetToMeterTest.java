package com.epam.exercise.conversion;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This is a test class.
 * @author Manasa_Maddali
 *
 */
public class FeetToMeterTest {
/**
 * This method is used to test conversion method in FeetToMeter class.
 */
	@Test
	public void test() {
		FeetToMeter fm=new FeetToMeter();
		double expectedValue=fm.conversion(5);
		double actualValue=1.524;
		assertEquals(actualValue,expectedValue,0.0);
		expectedValue=fm.conversion(10);
		actualValue=3.048;
		assertEquals(actualValue,expectedValue,0.0);
	}

}
