package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.util.SingletonScanner;

public class Menu {
	
	private UserService us = new UserService();
	private User loggedUser = null;
	private Scanner scan = SingletonScanner.getScanner().getScan();
	
	public void start() {
		
		mainLoop: while(true) {
			switch(startMenu()) {
				
			case 1:
				System.out.println("First name: ");
				String fname = scan.nextLine();
				System.out.println("Last name: ");
				String lname = scan.nextLine();
				System.out.println("Email address: ");
				String email = scan.nextLine();
				User u = us.login(fname, lname, email);
				if(u == null) {
					System.out.println("User not found.");
				}
				else {
					loggedUser = u;
					System.out.println("Welcome, Mr. " + u.getLname());
					switch (loggedUser.getType()) {
					case PASSENGER:
						passenger();
						break;
					case FREQUENT_FLYER:
						frequentFlyer();
						break;

					case TICKET_AGENT:
						ticketAgent();
						break;
					}
				}
				
			case 2:
				//register
				break;
			
			case 3:
				System.out.println("Goodbye!");
				break mainLoop;
				
			default: 
				System.out.println("Not a valid selection. Please try again.");
			}
		}
	}
	
	private int startMenu() {
		System.out.println("Welcome to Podunk Airlines!");
		System.out.println("Please select an option:");
		System.out.println("\t1. Check in for a flight.");
		System.out.println("\t2. Create an account.");
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
				System.out.println("Frequent Flyer status: Member");
				System.out.println("Frequent Flyer miles: " + loggedUser.getMiles());
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
	
	private int passengerMenu() {
		System.out.println("toString:" + loggedUser);
		System.out.println("What would you like to do?");
		System.out.println("\t1. Create a reservation");
		System.out.println("\t2. Check in");
		System.out.println("\t3. Check Frequent Flyer account");
		System.out.println("\t4. Logout");
		return select();
	}
	
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

	private void frequentFlyer() {
		
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
