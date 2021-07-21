package com.revature.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserType;

public class UserDAO {  //Database Access Object: Accesses data from persistence
	
	private static String filename = "users.dat";
	private static List<User> users;
	
	static {
		DataSerializer<User> ds = new DataSerializer<User>();
		users = ds.readObjectsFromFile(filename);
		
		//Populate a few users at startup if users.dat file is empty:
		if(users == null) {
			users = new ArrayList<User>();
			users.add(new User(users.size(), "Mr.", "Firsttime", "Flyer", "neverflownbefore@scared.com", LocalDate.of(2021, 07, 18)));
			User ff = new User(users.size(), "Dr.", "Fancy", "Pants", "flyeveryday@money.com", LocalDate.of(1980, 01, 01));
			ff.setType(UserType.FREQUENT_FLYER);
			ff.setMiles(2000l);
			
			users.add(ff);
			
			User agent = new User(users.size(), "Mr.", "Quentin", "Hardwick", "quentin.hardwick@revature.net", LocalDate.of(1984, 02, 8));
			agent.setType(UserType.TICKET_AGENT);
			users.add(agent);
			ds.writeObjectsToFile(users, filename);
			
		}
	}
	
	
	public void addUser (User u) {
		users.add(u);
		u.setFFID(users.size());
	}
	
	public User getUser(String fname, String lname, String email) {
		
		for (User u : users) {
			if (u.getFname().equals(fname) && u.getLname().equals(lname) && u.getEmail().equals(email)) {
				System.out.println("======================================");
				System.out.println(users);
				return u;
			}
		}
		return null;
	}
	
public User getUser(String fname, String lname, Integer ff) {
		
		for (User u : users) {
			if (u.getFname().equals(fname) && u.getLname().equals(lname) && u.getFFID().equals(ff)) {
				return u;
			}
		}
		return null;
	}
	
	public void updateUser (User u) {
		//Placeholder for week 3 database integration
	}
	
	public void writeToFile() {
		new DataSerializer<User>().writeObjectsToFile(users, filename);
	}
}
