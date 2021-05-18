package com.bridgelabz.greetingapp.controllers;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.models.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	public static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	private static AtomicInteger id = new AtomicInteger(0);
	
	@GetMapping("/greet")
	public Greeting getGreet() {
		logger.debug("Inside Get Greet");
		return new Greeting(id.incrementAndGet(), "Hello World");
	}
	
	@PostMapping("/addGreet")
	public Greeting addGreet(@RequestBody Greeting greeting) {
		logger.debug("Inside Post Greet");
		return new Greeting(id.incrementAndGet(), greeting.message);
	}
	
	@PutMapping("/{message1}")
	public Greeting updateGreet(@PathVariable String message1, @RequestParam(value = "name") String name) {
		logger.debug("Inside Put Greet");
		return new Greeting(id.incrementAndGet(), "Hey, " + name + " " + message1);
	}

}
