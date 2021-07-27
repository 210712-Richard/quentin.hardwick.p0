package com.revature.services;

import java.time.LocalDate;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.AirportObject;
import com.revature.beans.Flight;
import com.revature.beans.User;
import com.revature.data.FlightDAO;
import com.revature.data.UserDAO;

import jdk.internal.org.jline.utils.Log;

public class UserService {
	
	private Logger log = LogManager.getLogger(UserService.class);
	public UserDAO ud = new UserDAO();
	public FlightDAO fd = new FlightDAO();
	
	public User login(String email) {
		User u = ud.getUser(email);
		return u;
	}
	
	public User register(String title, String fname, String lname, String email, LocalDate bday) {
		User u = new User(title, fname, lname, email, bday);
		ud.addUser(u);
		ud.writeToFile();
		return u;
	}
	
	public boolean checkAvailability(String email) {
		return ud.getUsers().stream()
				.noneMatch((u)->u.getEmail().equalsIgnoreCase(email));
		
		// Translation:
		// for( User u : ud.getUsers()) {
		//     if(u.getEmail().equalsIgnoreCase(email) {
		//         return false;
		//     }
		// } 
		// return true;
	}
	
	public boolean checkBirthday(LocalDate bday) {
		LocalDate now = LocalDate.now();
		LocalDate fifteenYearsAgo = now.minusYears(15l);
		log.debug(now);
		log.debug(fifteenYearsAgo);
		return bday.isBefore(fifteenYearsAgo);
	}
	
	
	public String checkInMain(Integer flightNumber) {
		
		Flight flight = fd.getFlight(flightNumber);
		if (flight.getAvailableMain().size() < 1) {
			return null;
		}
		Random random = new Random();
		String seat = flight.getAvailableMain().remove(random.nextInt(flight.getAvailableMain().size()));
		fd.writeToFile();
		return seat;
	}
	
	public void depart(User user) {
		user.setMiles(user.getMiles() + AirportObject.MILES_BONUS);
		ud.writeToFile();
	}

}
