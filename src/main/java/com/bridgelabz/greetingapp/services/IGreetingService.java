package com.bridgelabz.greetingapp.services;

import java.util.List;

import com.bridgelabz.greetingapp.models.Greeting;
import com.bridgelabz.greetingapp.models.User;

public interface IGreetingService {
	Greeting addGreeting(User user);

	Greeting getGreetingById(Long id);
	
	List<Greeting> getAllGreetings();
}
