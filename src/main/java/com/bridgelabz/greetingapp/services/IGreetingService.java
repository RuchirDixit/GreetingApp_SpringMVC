package com.bridgelabz.greetingapp.services;

import java.util.List;

import com.bridgelabz.greetingapp.models.Greeting;
import com.bridgelabz.greetingapp.models.User;

public interface IGreetingService {
	/**
	 * To save Greeting record
	 * @param user : User object to save
	 * @return : Greeting
	 */
	Greeting addGreeting(User user);

	/**
	 * To get Greeting based on id
	 * @param id : To fetch greeting
	 * @return : Greeting
	 */
	Greeting getGreetingById(Long id);
	
	/**
	 * To get Json List of all Greetings present
	 * @return : List of Greetings
	 */
	List<Greeting> getAllGreetings();

	/**
	 * To update Greeting record or create new if doesn't exist
	 * @param greeting : Greeting object body
	 * @return : Greeting
	 */
	Greeting updateGreeting(Long id, Greeting greeting);

	/**
	 * To delete Greeting record by ID
	 * @param id : Id to delete
	 * @return: String
	 */
	String deleteById(Long id);
}
