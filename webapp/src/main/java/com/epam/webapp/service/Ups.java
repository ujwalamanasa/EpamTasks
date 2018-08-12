package com.epam.webapp.service;

import java.util.HashMap;
import java.util.Queue;

public interface Ups {
int unparking(HashMap<String, Integer> vehicle, String vehicleNumber, Queue<Integer> slotQueue);
}
