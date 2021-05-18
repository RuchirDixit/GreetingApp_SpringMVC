package com.bridgelabz.greetingapp.controllers;

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
import com.bridgelabz.greetingapp.services.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	public static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	private static AtomicInteger id = new AtomicInteger(0);
	
	@Autowired
	public IGreetingService greetingService;
	@GetMapping("/greet")
	public String getGreet() {
		logger.debug("Get greet from Service layer");
		return greetingService.getGreeting();
	}
	

}
