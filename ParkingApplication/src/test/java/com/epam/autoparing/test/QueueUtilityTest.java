package com.epam.autoparing.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import junit.framework.TestCase;
import com.epam.autoparking.main.Utility;

public class QueueUtilityTest {
	public void queueUtilityTest() {
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		Utility utilityTestObject = new Utility();
		vehicle.put("AP12AP1231", 5);
		vehicle.put("AP12AP1232", 10);
		vehicle.put("AP12AP1233", 9);
		vehicle.put("AP12AP1234", 7);
		vehicle.put("AP12AP1235", 4);
		Queue<Integer> actualQueue = new LinkedList<Integer>();
		actualQueue.add(1);
		actualQueue.add(2);
		actualQueue.add(3);
		actualQueue.add(6);
		actualQueue.add(8);
		assertEquals(actualQueue,utilityTestObject.queueUtility(vehicle, slotQueue, 10),0.0);
	}

	
	


	

	
}
