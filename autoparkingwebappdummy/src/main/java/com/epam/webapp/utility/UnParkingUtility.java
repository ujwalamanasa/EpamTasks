package com.epam.webapp.utility;

import java.util.HashMap;
import java.util.Queue;

import com.epam.webapp.service.UnParkingService;
import com.epam.webapp.service.WriteToLogFile;
import com.epam.webapp.service.WriteToTransactionFile;

public class UnParkingUtility {
	UnParkingService upservice = new UnParkingService();
	WriteToLogFile wf = new WriteToLogFile();
	WriteToTransactionFile wf1 = new WriteToTransactionFile();
	
	public int unparkingUtility(HashMap<String, Integer> vehicle, String vehicleNumber, Queue<Integer> slotQueue) {

		int allotedSlot = 0;
		if (vehicle.size() > 0) {

			
			allotedSlot = upservice.unparking(vehicle, vehicleNumber, slotQueue);

		} else {
			// throw new SlotEmptyException();
		}

		
		wf.writeToLogFile(vehicleNumber, allotedSlot, "OutTime");
	
		wf1.writeToTranscationFile(vehicle);
		return allotedSlot;
	}

}
