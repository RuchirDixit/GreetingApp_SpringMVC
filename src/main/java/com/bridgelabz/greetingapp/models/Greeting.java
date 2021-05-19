package com.bridgelabz.greetingapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greetings")
public class Greeting {

	@Id
	public Long id;
	public String message;
	
	public Greeting() {
		this.id = 0L;
		this.message = "";
	}
	public Greeting(Long id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
