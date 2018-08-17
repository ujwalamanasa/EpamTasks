package com.epam.webapp.test;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.webapp.service.ParkingService;
import com.epam.webapp.service.WriteToLogFile;
import com.epam.webapp.service.WriteToTransactionFile;
import com.epam.webapp.utility.ParkingUtility;

public class ParkingUtilityTest {
	

	@Test
	public void test() {
		ParkingService park = Mockito.mock(ParkingService.class);
		WriteToLogFile logObject = Mockito.mock(WriteToLogFile.class);
		WriteToTransactionFile transactionObject = Mockito.mock(WriteToTransactionFile.class);
		ParkingUtility utilityObject = new ParkingUtility();
		String vehicleNumber = "AP16EJ9008";
		int allotedSlot = 0;
		//int slot =;
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		when(park.parking(any(HashMap.class), any(Queue.class), anyString(), anyInt())).thenReturn(9);
		doNothing().when(logObject).writeToLogFile(anyString(),anyInt() , anyString() );
		doNothing().when(transactionObject).writeToTranscationFile(any(HashMap.class));
		assertEquals(9, utilityObject.parkingUtility(vehicle, slotQueue, vehicleNumber, 9));
	}

}
