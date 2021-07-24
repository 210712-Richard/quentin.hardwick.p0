package com.revature.menu;

import java.time.LocalDate;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.services.UserService;
import com.revature.util.SingletonScanner;

public class Menu {
	
	private UserService us = new UserService();
	private User loggedUser = null;
	private Scanner scan = SingletonScanner.getScanner().getScan();
	private UserDAO ud = new UserDAO();
	
	public void start() {
		
		mainLoop: while(true) {
			switch(startMenu()) {
				
			case 1:
				//Login
				System.out.println("Email address or Frequent Flyer number: ");
				String email = scan.nextLine();
				if(email.length() < 1) {
					email = "neverflownbefore@scared.com";
				}
				User u = us.login(email);
				if(u == null) {
					System.out.println("User not found.");
				}
				else {
					loggedUser = u;
					System.out.println("Welcome, " + loggedUser.getTitle() + " " + loggedUser.getLname());
					switch (loggedUser.getType()) {
					case PASSENGER:
					case FREQUENT_FLYER:
						passenger();
						break;

					case TICKET_AGENT:
						ticketAgent();
						break;
					}
				}
				
			case 2:
				//Register
				Register: while(true) {
					//Get title
					System.out.println("Title (Mr./Mrs./etc): ");
					String title = scan.nextLine();
					
					//Get first name
					System.out.println("First name: ");
					String fname = scan.nextLine();
					
					//Get last name
					System.out.println("Last name: ");
					String lname = scan.nextLine();
					
					//Get email address
					System.out.println("Email address: ");
					String newEmail = scan.nextLine();
					//Check if someone has already registered using this email address
					if(ud.getUser(newEmail) != null) {
						emailError: while(true) {
							switch(emailAlreadyRegistered(newEmail)) {
							case 1: //Go back to Home
								break Register;
							case 2: //Try again
								continue Register;
							default:
								continue emailError;
							}
						}
					}
					//Get birthday
					System.out.println("DOB (MM/DD/YYYY): ");
					String bday = scan.nextLine();
					String[] bdayArray = bday.split("/");
					LocalDate birthday;
					try {
					birthday = LocalDate.of(Integer.parseInt(bdayArray[2]), Integer.parseInt(bdayArray[0]), Integer.parseInt(bdayArray[1]));
					} catch(Exception e) {
						System.out.println("Invalid format. Date must be of the form MM/DD/YYYY");
						continue Register;
					}
					User newUser = new User(title,fname, lname, newEmail, birthday);
					ud.addUser(newUser);
					break Register;	
				}break;
			
			case 3:
				System.out.println("Goodbye!");
				System.exit(0);
				
			default: 
				System.out.println("Not a valid selection. Please try again.");
			}
		}
	}
//***********************   Start Menu   ***************************************	
	private int startMenu() {
		System.out.println("Welcome to Podunk Airlines!");
		System.out.println("Please select an option:");
		System.out.println("\t1. Login");
		System.out.println("\t2. Register");
		System.out.println("\t3. Quit");
		int selection = select();
		return selection;
	}
	
	private void passenger() {
		passenger: while(true) {
			switch (passengerMenu()) {
			case 1:
			case 2://Create reservation
				flight: while(true) {
					switch(flightMenu()){
						case 1:
							System.out.println("You are now booked for Billings, MT. Thank you for flying with us today!");
							break flight;
						case 2:
							System.out.println("You are now booked for South Bend, IN. Thank you for flying with us today!");
							break flight;
						case 3:
							System.out.println("You are now booked for Sarasota, FL. Thank you for flying with us today!");
							break flight;
						case 4:
							System.out.println("You are now booked for Northwest Arkansas, AS. Thank you for flying with us today!");
							break flight;
						case 5:
							System.out.println("You are now booked for Rochester, MS. Thank you for flying with us today!");
							break flight;
						case 6:
							break flight;
						default:
							System.out.println("Invalid option. Please choose again from our exciting list of destinations.");
					}
				} break;
			case 3: //Frequent flyer account
				System.out.println(loggedUser.getTitle() + " " + loggedUser.getLname() + ", " + loggedUser.getFname());
				System.out.println("Freq. Flyer number: " + loggedUser.getFfid());
				String status = "";
				switch (loggedUser.getType()) {
				case PASSENGER:
					status = "Member";
					break;

				case FREQUENT_FLYER:
					status = "Super Platinum Executive Member";
				}
				System.out.println("Freq. Flyer status: " + status);
				System.out.println("Freq. Flyer miles:  " + loggedUser.getMiles() + "\n");
				break;
				
			case 4:
				System.out.println("Goodbye");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
//**************************   Home Menu Options   *****************************	
	private int passengerMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1. Create a reservation");
		System.out.println("\t2. Check in");
		System.out.println("\t3. Check Frequent Flyer account");
		System.out.println("\t4. Logout");
		return select();
	}
//***************************	Destinations   *********************************
	private int flightMenu() {
		System.out.println("Where would you like to go?");
		System.out.println("\t1. Billings, MT (BIL)");
		System.out.println("\t2. South Bend, IN (SBD)");
		System.out.println("\t3. Sarasota, FL (SRQ)");
		System.out.println("\t4. Northwest Arkansas (XNA)");
		System.out.println("\t5. Rochester, MN (RST)");
		System.out.println("\t6. Go Back");
		return select();
	}
//***********************   Email already in use menu   ************************
	private int emailAlreadyRegistered (String newEmail){
		System.out.println(newEmail + "account already registered.");
		System.out.println("\t1. Go back to Home menu");
		System.out.println("\t2. Try again");
		return select();
	}
	private void ticketAgent() {
		
	}
	
	private int select() {
		int selection;
		try { 
			selection = Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			selection = -1;
		}
		return selection;
	}

}
