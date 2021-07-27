package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.Flight;
import com.revature.data.FlightDAO;

public class FlightService {
	
	private Logger log = LogManager.getLogger(FlightService.class);
	public FlightDAO fd = new FlightDAO();
	
	/*public boolean checkInMain(Integer flightNumber) {
		Flight flight = fd.getFlight(flightNumber);
		
	}*/
	
	public Flight flightInformation(Integer flightNumber) {
		Flight flight = fd.getFlight(flightNumber);
		return flight;
	}
}
