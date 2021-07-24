package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.data.UserDAO;

public class UserServiceTest {
	
	private static UserService service;
	private static User user;
	
	@BeforeAll // This method will run before any tests
	public static void setupClass() {
		user = new User();
		user.setEmail("Test");
	}
	
	@BeforeEach //This method will run before each test
	public void setUpTests () {
		service = new UserService(); //create a new user before every test to maximize isolation
		//user.setLastCheckin(LocalDate.of(1999, 1, 1)); // From GachaGame. I will need to convert to "flown" to make sure they get miles for each trip
		user.setMiles(2000l);
		service.ud = Mockito.mock(UserDAO.class);
	}
	
	@Test
	public void testRegister() {
		String title = "Doctor";
		String fname = "Test";
		String lname = "Test";
		String email = "test@test.test";
		LocalDate bday = LocalDate.of(1900, 1, 1);
		service.register(title, fname, lname, email, bday);
		
		// Mockito mock object allows us to receive paramaters from methods:
		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		
		// ud.addUser() was called with our user as an argument:
		Mockito.verify(service.ud).addUser(captor.capture());
		
		// ud.writeToFile() was called:
		Mockito.verify(service.ud).writeToFile();
		
		// A user is created with the given arguments:
		// User is of type PASSENGER
		// User has starting miles of 1000l
		User u = captor.getValue();
		assertEquals(0l,u.getMiles(), "Asserting starting miles is 0");
		assertEquals(UserType.PASSENGER, u.getType(), "Asserting starting type is PASSENGER");
		assertEquals(title, u.getTitle(), "Asserting Title is correct");
		assertEquals(fname, u.getFname(), "Asserting First Name is correct");
		assertEquals(lname, u.getLname(), "Asserting Last Name is correct");
		assertEquals(email, u.getEmail(), "Asserting Email is correct");
		assertEquals(bday, u.getBday(), "Asserting Birthday is correct");
	}
	
}
