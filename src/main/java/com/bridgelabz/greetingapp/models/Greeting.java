package com.bridgelabz.greetingapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greetings")
public class Greeting {

	@Id
	public int id;
	public String message;
	
	public Greeting() {
		this.id = 0;
		this.message = "";
	}
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
