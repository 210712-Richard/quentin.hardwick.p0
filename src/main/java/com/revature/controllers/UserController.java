package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.Flight;
import com.revature.beans.User;
import com.revature.data.FlightDAO;
import com.revature.services.UserService;

import io.javalin.http.Context;

public class UserController {
	
	private static Logger log = LogManager.getLogger(UserController.class);
	private UserService us = new UserService();
	public FlightDAO fd = new FlightDAO();
	
	
	public void register(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		if(us.checkAvailability(u.getEmail())) {
			User newUser = us.register(u.getTitle(), u.getFname(), u.getLname(), u.getEmail(), u.getBday());
			ctx.status(201);
			ctx.json(newUser);
		} else {
			ctx.status(409);
			ctx.html("Email already registered.");
		}
	}

	public void login(Context ctx) {
		log.trace("Login method called");
		log.debug(ctx.body());
		// Try to use JSON marshaller to create a body as a User class
		User u = ctx.bodyAsClass(User.class);
		log.debug(u);
		
		
		u = us.login(u.getEmail());
		log.debug(u);
		
		if (u != null) {
			ctx.sessionAttribute("loggedUser", u);
			ctx.json(u);
			return;
		}
		
		// Send a 401 "Authentication Error" if login not successful
		ctx.status(401);
	}
	
	public void logout(Context ctx) {
		ctx.req.getSession().invalidate();
		ctx.status(204);
	}
	
	public void getMiles(Context ctx) {
		String email = ctx.pathParam("email");
		User loggedUser = ctx.sessionAttribute("loggedUser");
		if (loggedUser == null || !loggedUser.getEmail().equalsIgnoreCase(email)) {
			ctx.status(403);
			return;
		}
		ctx.json(loggedUser.getMiles());
	}
	
	public void checkinMain(Context ctx) {
		String email = ctx.pathParam("email");
		User loggedUser = ctx.sessionAttribute("loggedUser");
		if(loggedUser == null || !loggedUser.getEmail().equalsIgnoreCase(email)) {
			ctx.status(403);
			return;
		}
		Flight flight = ctx.bodyAsClass(Flight.class);
		String flightNumber = ctx.pathParam("flight");
		log.debug(flightNumber);
		flight = fd.getFlight(Integer.parseInt(flightNumber));
		loggedUser.setFlight(flight);
		loggedUser.setSeat(us.checkInMain(Integer.parseInt(flightNumber)));
		
	}
}
