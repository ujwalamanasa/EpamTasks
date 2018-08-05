package com.epam.autoparking.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class WriteToTransactionFile {
	public void writeToTranscationFile(HashMap<String, Integer> vehicle) {
		try {
			BufferedWriter writerObject = null;
			writerObject = new BufferedWriter(new FileWriter("Transaction1.csv"));
			for (Entry<String, Integer> entry : vehicle.entrySet()) {
				writerObject.write(entry.getKey());
				writerObject.write(",");
				writerObject.write(entry.getValue().toString());
				writerObject.newLine();
			}
			writerObject.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
