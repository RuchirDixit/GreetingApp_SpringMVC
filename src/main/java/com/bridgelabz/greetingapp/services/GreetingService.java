package com.bridgelabz.greetingapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.controllers.GreetingController;

@Service
public class GreetingService implements IGreetingService {

	public static final Logger logger = LoggerFactory.getLogger(GreetingService.class);
	@Override
	public String getGreeting() {
		logger.debug("Inside Greeting service: get Greet method");
		return "Hello World From Service";
	}

}
