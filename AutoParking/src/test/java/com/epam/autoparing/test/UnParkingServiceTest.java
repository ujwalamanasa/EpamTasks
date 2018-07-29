package com.epam.autoparing.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.epam.autoparking.service.UnParkingService;

import junit.framework.TestCase;
/**
 * 
 * @author Manasa_Maddali
 *
 */
public class UnParkingServiceTest extends TestCase {

	UnParkingService ups = new UnParkingService();
	HashMap<String,Integer> vehicles=new HashMap<String,Integer>();
	Queue<Integer> slotQueue = new LinkedList<Integer>();
	String vehicleNumber="AP12AP1234";
	int slot=1;
	vehicles.put(vehicleNumber, slot);

	

}
