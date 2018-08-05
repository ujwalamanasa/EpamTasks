package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
/**
 * This class inserts values from a file to hashmap.
 * @author Manasa_Maddali
 *
 */
public class FileToHashMap {
	public HashMap<String, Integer> copyFileToHashMap() {
		HashMap<String, Integer> vehicle =
				new HashMap<String, Integer>();
		BufferedReader readerObject;
		try {
			readerObject =
		new BufferedReader(new FileReader("Transaction1.csv"));
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

