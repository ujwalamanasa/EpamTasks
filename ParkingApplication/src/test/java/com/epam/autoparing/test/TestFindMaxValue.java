package com.epam.autoparing.test;

import java.util.HashMap;
import com.epam.autoparking.main.Utility;

import junit.framework.TestCase;

public class TestFindMaxValue extends TestCase {
	Utility utilityTestObject = new Utility();
	HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
	

	public void testFindMaxValue() {

		vehicle.put("AP12AP1231", 5);
		vehicle.put("AP12AP1232", 10);
		vehicle.put("AP12AP1233", 9);
		vehicle.put("AP12AP1234", 7);
		vehicle.put("AP12AP1235", 4);
		assertEquals(10, utilityTestObject.findMaxValue(vehicle), 0.0);

	}

	

}
