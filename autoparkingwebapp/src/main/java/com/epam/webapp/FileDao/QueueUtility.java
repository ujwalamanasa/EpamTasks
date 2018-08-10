package com.epam.webapp.FileDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class QueueUtility {
	public Integer findMaxValue(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue) {
		Integer maxValue;

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

		return maxValue;

	}

}
