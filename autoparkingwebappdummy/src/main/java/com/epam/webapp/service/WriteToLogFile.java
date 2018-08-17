package com.epam.webapp.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToLogFile {
	public void writeToLogFile(String vehicleNumber, Integer slotNumber, String time) {
		try {
			BufferedWriter writerObject = null;
			writerObject = new BufferedWriter(new FileWriter("Log.csv", true));
			java.util.Date timer = new java.util.Date();
			writerObject.write(vehicleNumber);
			writerObject.write(slotNumber.toString());
			writerObject.write(time);
			writerObject.write(timer.toString());
			writerObject.newLine();
			writerObject.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
