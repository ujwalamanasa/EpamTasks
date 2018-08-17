package com.epam.webapp.filedao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoadTotalSlots {
	public int checkFileExistance() {
		File fileObj = new File("SlotFile.csv");
		int totalSlots = -1;
		try {
			
			if (fileObj.exists()) {
				BufferedReader br = new BufferedReader(new FileReader("SlotFile.csv"));
				totalSlots = Integer.parseInt(br.readLine());
				br.close();
			}

			
		} catch (Exception emsg) {
			System.out.println(emsg);
		}

		return totalSlots;
	}
}
