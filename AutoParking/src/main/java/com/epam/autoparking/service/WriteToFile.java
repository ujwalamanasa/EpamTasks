package com.epam.autoparking.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class WriteToFile {

	public void writeToTranscationFile(HashMap<String, Integer> vehicle) {
		try {
			BufferedWriter bw = null;
			System.out.println(vehicle);
			bw = new BufferedWriter(new FileWriter("Transaction1.csv"));
			for (Entry<String, Integer> entry : vehicle.entrySet()) {
				bw.write(entry.getKey());
				bw.write(",");
				bw.write(entry.getValue().toString());
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void writeToLogFile(String vehicleNumber, Integer slotNumber, char ch) {
		try {
			BufferedWriter bw1 = null;

			bw1 = new BufferedWriter(new FileWriter("Log.csv", true));

			if (ch == 'p') {
				bw1.write(vehicleNumber);
				bw1.write(slotNumber.toString());
				bw1.write(" InTime ");
				java.util.Date time = new java.util.Date();
				String time1 = time.toString();
				bw1.write(time1);
				bw1.newLine();
			} else {
				bw1.write(vehicleNumber);
				bw1.write(slotNumber.toString());
				bw1.write(" OutTime ");
				java.util.Date time = new java.util.Date();
				String time1 = time.toString();
				bw1.write(time1);
				bw1.newLine();
			}
			bw1.close();
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

}
