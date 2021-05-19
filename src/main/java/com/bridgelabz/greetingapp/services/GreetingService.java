package com.bridgelabz.greetingapp.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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
	private static AtomicLong id = new AtomicLong(0);
	
	@Autowired
	GreetingRepository greetingRepository;
	
	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty() ? "World" : user.toString()));
		return greetingRepository.save(new Greeting(id.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(Long id) {
		return greetingRepository.findById(id).get();
	}

	@Override
	public List<Greeting> getAllGreetings() {
		return greetingRepository.findAll();
	}
	
	

}
