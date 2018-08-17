package com.epam.webapp.utility;

import java.util.HashMap;
import java.util.Queue;

import com.epam.webapp.service.ParkingService;
import com.epam.webapp.service.WriteToLogFile;
import com.epam.webapp.service.WriteToTransactionFile;

public class ParkingUtility {
	ParkingService park = new ParkingService();
	WriteToLogFile writeLog = new WriteToLogFile();
	WriteToTransactionFile wf1 = new WriteToTransactionFile();
	HashMap<String, Integer> vehicles = null;
	public int parkingUtility(final HashMap<String, Integer> vehicle, final Queue<Integer> slotQueue,
			final String vehicleNumber, Integer slot) {
		
		int allotedSlot = -1;
		
		allotedSlot = park.parking(vehicle, slotQueue, vehicleNumber, slot);
	
		writeLog.writeToLogFile(vehicleNumber, allotedSlot, "InTime");
		
		wf1.writeToTranscationFile(vehicle);
		vehicles = vehicle;
		return allotedSlot;

	}
	
	public HashMap<String, Integer> getData(){
		return vehicles;
	}

}
