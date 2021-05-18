package com.bridgelabz.greetingapp.services;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.controllers.GreetingController;
import com.bridgelabz.greetingapp.models.Greeting;
import com.bridgelabz.greetingapp.models.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {

	public static final Logger logger = LoggerFactory.getLogger(GreetingService.class);
	public static final String template = "Hello %s!";
	private static AtomicInteger id = new AtomicInteger(0);
	
	@Autowired
	GreetingRepository greetingRepository;
	
	@Override
	public Greeting getGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty() ? "World" : user.toString()));
		return greetingRepository.save(new Greeting(id.incrementAndGet(), message));
	}
	

}
