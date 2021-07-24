package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.services.UserService;

import io.javalin.http.Context;

public class UserController {
	
	private static Logger log = LogManager.getLogger(UserController.class);
	private UserService us = new UserService();
	
	public void login(Context ctx) {
		log.trace("Login method called");
		log.debug(ctx.body());
	}
}
