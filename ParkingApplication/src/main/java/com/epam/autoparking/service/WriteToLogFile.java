package com.epam.autoparking.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToLogFile {
	public void writeToLogFile(String vehicleNumber, Integer slotNumber, char charFlag) {
		try {
			BufferedWriter writerObject = null;
			writerObject = new BufferedWriter(new FileWriter("Log.csv", true));
			java.util.Date time = new java.util.Date();
			writerObject.write(vehicleNumber);
			writerObject.write(slotNumber.toString());
			if (charFlag == 'p') {
				writerObject.write(" InTime ");
				writerObject.write(time.toString());
				writerObject.newLine();
			} else {
				writerObject.write(" OutTime ");
				writerObject.write(time.toString());
				writerObject.newLine();
			}
			writerObject.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
