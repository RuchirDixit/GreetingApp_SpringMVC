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
		logger.debug("Inside add Greeting Service");
		String message = String.format(template, (user.toString().isEmpty() ? "World" : user.toString()));
		return greetingRepository.save(new Greeting(id.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(Long id) {
		logger.debug("Inside get Greeting By Id Service");
		return greetingRepository.findById(id).get();
	}

	@Override
	public List<Greeting> getAllGreetings() {
		logger.debug("Inside get All Greeting Service");
		return greetingRepository.findAll();
	}

	@Override
	public Greeting updateGreeting(Long id, Greeting greeting) {
		logger.debug("Inside update Greeting by ID Service");
		return greetingRepository.findById(id).map(greetingToUpdate -> {
			greetingToUpdate.setId(greeting.id);
			greetingToUpdate.setMessage(greeting.message);
			return greetingRepository.save(greetingToUpdate);
		}).orElseGet(()-> {
			greeting.setId(id);
			return greetingRepository.save(greeting);
		});
	}

	@Override
	public String deleteById(Long id) {
		logger.debug("Inside delete Greeting by ID Service");
		greetingRepository.deleteById(id);
		return "Record Deleted!";
	}
	
	

}
