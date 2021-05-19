package com.bridgelabz.greetingapp.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.models.Greeting;
import com.bridgelabz.greetingapp.models.User;
import com.bridgelabz.greetingapp.services.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	public static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	public IGreetingService greetingService;
	
	@GetMapping("/greet")
	public Greeting getGreet(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.debug("Get greet from Service layer with options");
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);		
	}
	
	@GetMapping("/getId")
	public Greeting getGreetingById(@RequestParam("id") Long id) {
		return greetingService.getGreetingById(id);
	}
	
	@GetMapping("/get")
	public List<Greeting> getAllGreets() {
		return greetingService.getAllGreetings();
	}
	
	@PutMapping("/updateGreeting")
	public Greeting updateEmployee(@RequestBody Greeting greeting) {
		return greetingService.updateGreeting(greeting.getId(),greeting);
	}

}
