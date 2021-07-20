package com.revature.services;

import com.revature.beans.AirportObject;
import com.revature.beans.User;
import com.revature.data.UserDAO;

public class UserService {
	
	public UserDAO ud = new UserDAO();
	
	public User login(String fname, String lname, String email) {
		User u = ud.getUser(fname, lname, email);
		return u;
	}
	
	public User login(String fname, String lname, Integer ff) {
		User u = ud.getUser(fname, lname, ff);
		return u;
	}
	
	public void depart(User user) {
		user.setMiles(user.getMiles() + AirportObject.MILES_BONUS);
		ud.writeToFile();
	}

}
