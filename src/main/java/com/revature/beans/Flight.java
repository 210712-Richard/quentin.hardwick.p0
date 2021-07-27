package com.revature.beans;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int businessCapacity = 9;
	private int mainCapacity = 48;
	private Integer flightNumber;
	private String destination;
	private ArrayList<String> availableBusiness = new ArrayList<>();
	private ArrayList<String> availableMain = new ArrayList<>();
	private Long distance;
	private String seatMap;
	private String availability;
	private LocalTime departureTime;
	private ArrayList<User> passengers = new ArrayList<>();
	
	public Flight (Integer number, String destination, Long distance, LocalTime departureTime) {
		super();
		this.flightNumber = number;
		this.destination = destination;
		this.distance = distance;
		this.departureTime = departureTime;
		char[] business = {'A', 'C', 'D'};
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				String seat = "" +i + business[j];
				this.availableBusiness.add(seat);
			}
		}
		
		char[] main = {'A', 'C', 'D', 'F'};
		for (int i = 4; i < 16; i++) {
			for (int j = 0; j < 4; j++) {
				String seat = "" +i + main[j];
				this.availableMain.add(seat);
			}
		}
	}
	
	public String book(String seat) {
		return seat;
	}
//********************   Getters and Setters   *********************************
	public int getBusinessCapacity() {
		return businessCapacity;
	}

	public void setBusinessCapacity(int businessCapacity) {
		this.businessCapacity = businessCapacity;
	}

	public int getMainCapacity() {
		return mainCapacity;
	}

	public void setMainCapacity(int mainCapacity) {
		this.mainCapacity = mainCapacity;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public ArrayList<String> getAvailableBusiness() {
		return availableBusiness;
	}

	public void setAvailableBusiness(ArrayList<String> availableBusiness) {
		this.availableBusiness = availableBusiness;
	}

	public ArrayList<String> getAvailableMain() {
		return availableMain;
	}

	public void setAvailableMain(ArrayList<String> availableMain) {
		this.availableMain = availableMain;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public String getSeatMap() {
		return seatMap;
	}
	
	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public ArrayList<User> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<User> passengers) {
		this.passengers = passengers;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getAvailability() {
		int business = this.availableBusiness.size();
		int main = this.availableMain.size();
		availability = "Business: " + business + "\nMain: " + main;
		return availability;
	}
	
	public String checkInMain() {
		if (this.getAvailableMain().size() < 1) {
			return null;
		}
		Random random = new Random();
		String seat = this.getAvailableMain().remove(random.nextInt(this.getAvailableMain().size()));
		return seat;
	}
//***********************   Hash Code and Equals   *****************************
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((availableBusiness == null) ? 0 : availableBusiness.hashCode());
		result = prime * result + ((availableMain == null) ? 0 : availableMain.hashCode());
		result = prime * result + businessCapacity;
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + flightNumber;
		result = prime * result + mainCapacity;
		result = prime * result + ((seatMap == null) ? 0 : seatMap.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (availableBusiness == null) {
			if (other.availableBusiness != null)
				return false;
		} else if (!availableBusiness.equals(other.availableBusiness))
			return false;
		if (availableMain == null) {
			if (other.availableMain != null)
				return false;
		} else if (!availableMain.equals(other.availableMain))
			return false;
		if (businessCapacity != other.businessCapacity)
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (flightNumber != other.flightNumber)
			return false;
		if (mainCapacity != other.mainCapacity)
			return false;
		if (seatMap == null) {
			if (other.seatMap != null)
				return false;
		} else if (!seatMap.equals(other.seatMap))
			return false;
		return true;
	}
//****************************   toString   ************************************
	@Override
	public String toString() {
		return "\tFlt: PA" + flightNumber + "   Dest:" + destination + "Dep: " + departureTime
				+ "\n   -------------------------------"
				+ "\n     Avail  | Booked  | Capacity"
				+ "\n\nBus    " + availableBusiness.size() + "\t"
				+ (businessCapacity - availableBusiness.size())
				+ "\t   " + businessCapacity + "\nMain  " + availableMain.size() + "\t"
				+ (mainCapacity - availableMain.size())
				+ "\t  " + mainCapacity;
	}		
}
