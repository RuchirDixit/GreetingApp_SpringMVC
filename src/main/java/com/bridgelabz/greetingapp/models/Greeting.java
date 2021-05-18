package com.bridgelabz.greetingapp.models;

public class Greeting {

	public int id;
	public String message;
	
	public Greeting(int id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
}
