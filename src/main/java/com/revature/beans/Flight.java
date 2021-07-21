package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements Serializable {
	private int businessCapacity = 9;
	private int mainCapacity = 48;
	private int flightNumber;
	private String destination;
	private ArrayList<Seat> availableBusiness = new ArrayList<>();
	private ArrayList<Seat> availableMain = new ArrayList<>();
	private Long distance;
	private String seatMap;
	private String availability;
	
	public static void main(String[] args) {
		Flight x = new Flight(2000, "EYW", 1000l);
		System.out.println(x);
	}
	
	public Flight (Integer number, String destination, Long distance) {
		super();
		this.flightNumber = number;
		this.destination = destination;
		this.distance = distance;
		char[] business = {'A', 'C', 'D'};
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				Seat seat = new Seat(i, business[j]);
				this.availableBusiness.add(seat);
			}
		}
		
		char[] main = {'A', 'C', 'D', 'F'};
		for (int i = 4; i < 16; i++) {
			for (int j = 0; j < 4; j++) {
				Seat seat = new Seat(i, main[j]);
				this.availableMain.add(seat);
			}
		}
	}
	
	public Seat book(String seat) {
		
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

	public int getFlightNumber() {
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

	public ArrayList<Seat> getAvailableBusiness() {
		return availableBusiness;
	}

	public void setAvailableBusiness(ArrayList<Seat> availableBusiness) {
		this.availableBusiness = availableBusiness;
	}

	public ArrayList<Seat> getAvailableMain() {
		return availableMain;
	}

	public void setAvailableMain(ArrayList<Seat> availableMain) {
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

	public String getAvailability() {
		int business = this.availableBusiness.size();
		int main = this.availableMain.size();
		availability = "Business: " + business + "\nMain: " + main;
		return availability;
	}
//************************   HashCode and Equals   *****************************
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((availableBusiness == null) ? 0 : availableBusiness.hashCode());
		result = prime * result + ((availableMain == null) ? 0 : availableMain.hashCode());
		result = prime * result + businessCapacity;
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
		return "\tFlt: PA" + flightNumber + "   Dest:" + destination
				+ "\n   -------------------------------"
				+ "\n     Avail  | Booked  | Capacity"
				+ "\n\nBus    " + availableBusiness.size() + "\t"
				+ (businessCapacity - availableBusiness.size())
				+ "\t   " + businessCapacity + "\nMain  " + availableMain.size() + "\t"
				+ (mainCapacity - availableMain.size())
				+ "\t  " + mainCapacity;
	}	
	
	
	
}
//******************************************************************************
//**********************   Seat Class   ****************************************
class Seat {
	private int row;
	private char column;
	private Boolean available = true;
	
	public Seat(Integer row, char column) {
		super();
		this.row = row;
		this.column = column;
	}
//******************   Getters and Setters   ***********************************
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
//*******************   HashCode and Equals   **********************************
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((available == null) ? 0 : available.hashCode());
		result = prime * result + column;
		result = prime * result + row;
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
		Seat other = (Seat) obj;
		if (available == null) {
			if (other.available != null)
				return false;
		} else if (!available.equals(other.available))
			return false;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	@Override
//************************   toString   ****************************************
	public String toString() {
		return "" + row + column;
	}
	
	
	
}