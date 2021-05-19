package com.bridgelabz.greetingapp.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	/**
	 * To add data into Greeting object
	 * @param name : name of User to add to Greeting message
	 * @return : Greeting
	 */
	@GetMapping("/greet")
	public Greeting getGreet(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.debug("Get greet from Service layer with options");
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);		
	}
	
	/**
	 * To get Greeting based on id
	 * @param id : To fetch greeting
	 * @return : Greeting
	 */
	@GetMapping("/getId")
	public Greeting getGreetingById(@RequestParam("id") Long id) {
		logger.debug("Inside get Greeting By Id Controller!");
		return greetingService.getGreetingById(id);
	}
	
	/**
	 * To get Json List of all Greetings present
	 * @return : List of Greetings
	 */
	@GetMapping("/get")
	public List<Greeting> getAllGreets() {
		logger.debug("Inside get All Greeting Controller");
		return greetingService.getAllGreetings();
	}
	
	/**
	 * To update Greeting record or create new if doesn't exist
	 * @param greeting : Greeting object body
	 * @return : Greeting
	 */
	@PutMapping("/updateGreeting")
	public Greeting updateGreeting(@RequestBody Greeting greeting) {
		logger.debug("Inside update Greeting by ID Controller");
		return greetingService.updateGreeting(greeting.getId(),greeting);
	}
	
	/**
	 * To delete Greeting record by ID
	 * @param id : Id to delete
	 * @return: String
	 */
	@DeleteMapping("/deleteGreeting/{id}")
	public String deleteGreetingById(@PathVariable Long id) {
		logger.debug("Inside delete Greeting by ID Controller");
		return greetingService.deleteById(id);
	}

}
