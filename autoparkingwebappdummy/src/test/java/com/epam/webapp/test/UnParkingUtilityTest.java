package com.epam.webapp.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import org.mockito.Mockito;

import com.epam.webapp.service.UnParkingService;
import com.epam.webapp.service.WriteToLogFile;
import com.epam.webapp.service.WriteToTransactionFile;
import com.epam.webapp.utility.UnParkingUtility;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

public class UnParkingUtilityTest {

@Test
public void Test() {
	UnParkingService upService =  Mockito.mock(UnParkingService.class);
	WriteToLogFile logObject = Mockito.mock(WriteToLogFile.class);
	WriteToTransactionFile transactionObject = Mockito.mock(WriteToTransactionFile.class);
	HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
	Queue<Integer> slotQueue = new LinkedList<Integer>();

	String vehicleNumber = "AP12AP1234";
	when(upService.unparking(any(HashMap.class), anyString(), any(Queue.class))).thenReturn(0);
	doNothing().when(logObject).writeToLogFile(anyString(),anyInt(),anyString());
	doNothing().when(transactionObject).writeToTranscationFile(any(HashMap.class));
	UnParkingUtility unpark = new UnParkingUtility();
	
	assertEquals(0,unpark.unparkingUtility(vehicle, vehicleNumber, slotQueue));


	
}
}
