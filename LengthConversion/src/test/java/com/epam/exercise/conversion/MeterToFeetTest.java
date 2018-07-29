package com.epam.exercise.conversion;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This is a test class.
 * @author Manasa_Maddali
 *
 */
public class MeterToFeetTest {
/**
 * This method is used to test conversion method in MeterToFeet class.
 */
	@Test
	public void test() {
		MeterToFeet mf=new MeterToFeet();
		double expectedValue=mf.conversion(10);
		double actualValue=32.8;
		assertEquals(actualValue,expectedValue,0.0);
		expectedValue=mf.conversion(25);
		actualValue=82.0;
		assertEquals(actualValue,expectedValue,0.0);
	}

}
