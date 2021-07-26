package com.revature.data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.revature.beans.Flight;

public class FlightDAO {
	
	private static String filename = "flight.dat";
	private static List<Flight> flights;
	
	static {
		DataSerializer<Flight> ds = new DataSerializer<Flight>();
		flights = ds.readObjectsFromFile(filename);
		
		if(flights == null) {
			flights = new ArrayList<Flight>();
			
			flights.add(new Flight(2167, "DSM", 500l, LocalTime.of(07, 30)));
			flights.add(new Flight(2168, "DSM", 500l, LocalTime.of(12, 30)));
			flights.add(new Flight(2169, "DSM", 500l, LocalTime.of(17, 30)));
			
			flights.add(new Flight(2679, "BIL", 500l, LocalTime.of(8, 30)));
			flights.add(new Flight(2680, "BIL", 500l, LocalTime.of(13, 30)));
			flights.add(new Flight(2681, "BIL", 500l, LocalTime.of(18, 30)));
			
			flights.add(new Flight(2521, "SBD", 500l, LocalTime.of(10, 05)));
			flights.add(new Flight(2522, "SBD", 500l, LocalTime.of(11, 05)));
			flights.add(new Flight(2523, "SBD", 500l, LocalTime.of(12, 05)));
			
			flights.add(new Flight(2200, "ILG", 500l, LocalTime.of(04, 30)));
			flights.add(new Flight(2201, "ILG", 500l, LocalTime.of(23, 30)));
			
		}
	}
	
	public void addFlight(Flight flight) {
		flights.add(flight);
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	
	public Flight getFlight(Integer flightNumber) {
		return flights.stream()
				.filter((flt) -> flt.getFlightNumber().equals(flightNumber))
				.findFirst()
				.orElse(null);
	}
	
	public List<Flight> getSchedule(String destination){
		return flights.stream()
				.filter((flt)->flt.getDestination().equalsIgnoreCase(destination))
						.collect(Collectors.toList());
	}
	
	public void writeToFile() {
		new DataSerializer<Flight>().writeObjectsToFile(flights, filename);
	}

}
