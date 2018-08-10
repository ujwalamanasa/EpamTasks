package com.epam.webapp.FileDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CopyToHashMap {
	public HashMap<String, Integer> copyFileToHashMap() {
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		BufferedReader readerObject;
		try {
			readerObject = new BufferedReader(new FileReader("Transaction.csv"));
			String line = "";
			while ((line = readerObject.readLine()) != null) {
				String[] vehicles = line.split(",");
				int slotNumber = Integer.parseInt(vehicles[1]);
				vehicle.put(vehicles[0], slotNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}
}
