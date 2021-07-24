package com.revature;

import com.revature.controllers.UserController;
import com.revature.menu.Menu;

import io.javalin.Javalin;

public class Driver {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(8080);
		UserController uc = new UserController();
		
		app.get("/", (ctx)->ctx.html("Hello World"));
		
		// object::method references a method as a function we can pass to a method
		app.post("/users", uc::login);
	}
}