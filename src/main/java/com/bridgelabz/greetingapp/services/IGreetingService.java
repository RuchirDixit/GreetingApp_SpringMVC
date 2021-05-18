package com.bridgelabz.greetingapp.services;

import com.bridgelabz.greetingapp.models.Greeting;
import com.bridgelabz.greetingapp.models.User;

public interface IGreetingService {
	Greeting addGreeting(User user);

	Greeting getGreetingById(Long id);
}
