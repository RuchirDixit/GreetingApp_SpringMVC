package com.bridgelabz.greetingapp.services;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.controllers.GreetingController;
import com.bridgelabz.greetingapp.models.Greeting;
import com.bridgelabz.greetingapp.models.User;

@Service
public class GreetingService implements IGreetingService {

	public static final Logger logger = LoggerFactory.getLogger(GreetingService.class);
	public static final String template = "Hello %s!";
	private static AtomicInteger id = new AtomicInteger(0);
	@Override
	public Greeting getGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty() ? "World" : user.toString()));
		return new Greeting(id.incrementAndGet(), message);
	}
	

}
