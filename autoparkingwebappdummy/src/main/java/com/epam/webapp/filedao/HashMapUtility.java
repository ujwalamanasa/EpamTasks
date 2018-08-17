package com.epam.webapp.filedao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class HashMapUtility {

	public void copyFileToHashMap(HashMap<String, Integer> vehicle) {

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

	}

	public int findMaxValue(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue) {
		int maxValue = 0;
		if (vehicle.size() != 0) {

			Map.Entry<String, Integer> maxEntry = null;
			for (Map.Entry<String, Integer> entry : vehicle.entrySet()) {
				if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
					maxEntry = entry;
				}
			}
			maxValue = maxEntry.getValue();
			for (int index = 1; index <= maxValue; index++) {
				if (vehicle.containsValue(index)) {
					continue;
				} else {
					slotQueue.add(index);
				}
			}
		}

		return maxValue;

	}
	
}
