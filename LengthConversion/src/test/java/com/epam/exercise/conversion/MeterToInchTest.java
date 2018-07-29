package com.epam.exercise.conversion;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This is a test class.
 * @author Manasa_Maddali
 *
 */
public class MeterToInchTest {
/**
 * This method is used to test conversion method in MeterToInch class.
 */
	@Test
	public void test() {
		MeterToInch mi=new MeterToInch();
		double expectedValue=mi.conversion(10);
		double actualValue=393.7;
		assertEquals(actualValue,expectedValue,0.0);
		expectedValue=mi.conversion(25);
		actualValue=984.2499999999999;
		assertEquals(actualValue,expectedValue,0.0);
	}

}
