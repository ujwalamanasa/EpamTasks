package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class ReadFromFile {
public HashMap<String,Integer> copyFileToHashMap(){
	HashMap<String,Integer> vehicle = new HashMap<String,Integer>();
	BufferedReader br;
	try {
		br = new BufferedReader(new FileReader("Transaction1.csv"));
	
	String line="";
	
	while ((line = br.readLine()) != null) 
	{
		
	    String record[] = line.split(",");
	    int slotNumber = Integer.parseInt(record[1]);
	      vehicle.put(record[0], slotNumber);
     }
	}
	
	 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return vehicle;
	
}
}
