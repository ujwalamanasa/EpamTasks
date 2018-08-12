package com.epam.webapp.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.epam.webapp.exception.VehicleNotParkedException;
import com.epam.webapp.service.UnParkingService;
import com.epam.webapp.service.Ups;
@RunWith(MockitoRunner.class)
public class VehicleNotParkedExceptionTest {
	

	   //@Mock annotation is used to create the mock object to be injected
	  
	   CalculatorService calcService;
@TestSubject
		UnParkingService unpark = new UnParkingService();
@Mock
Ups upsObject;
@Test(expected = VehicleNotParkedException.class)
public void testAdd(){
	HashMap<String, Integer> vehicles = new HashMap<String, Integer>();
	Queue<Integer> slotQueue = new LinkedList<Integer>();
	vehicles.put("AP12AP1234", 1);
	vehicles.put("AP3HG3109", 2);
	unpark.unparking(vehicles, "AP12AP1234", slotQueue);
	 unpark.unparking(vehicles, "AP12AH8234", slotQueue);
    doThrow(new VehicleNotParkedException())
       .when(upsObject).;

    //test the add functionality
  //  Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0); 
		
	
		
	
	}

}
