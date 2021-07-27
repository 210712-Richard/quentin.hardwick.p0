package com.revature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.controllers.UserController;
import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJackson;

public class Driver {
	public static void main(String[] args) {
		// Set up Jackson to serialize LocalDates and LocalDateTimes
		ObjectMapper jackson = new ObjectMapper();
		jackson.registerModule(new JavaTimeModule());
		jackson.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		JavalinJackson.configure(jackson);
				
		Javalin app = Javalin.create().start(8080);
		UserController uc = new UserController();
		
		// object::method references a method as a function we can pass to a method
		// ("/users/:email/miles", uc::getMiles) => calls the UserController's getMiles() method
		// using the specified :email as an argument
		
		//As a user I can register for an account
		app.put("/users/:email", uc::register);
		
		// As a user I can log in
		app.post("/users", uc::login);
		
		//As a user I can log out
		app.delete("/users", uc::logout);
		
		//As a user I check my freq flyer miles
		app.get("/users/:email/miles", uc::getMiles);
		
		//As a user I can check in for a flight
		app.get("users/:email/:flight", uc::checkinMain);
	}
}