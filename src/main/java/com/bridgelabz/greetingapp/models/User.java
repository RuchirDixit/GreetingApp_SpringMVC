package com.bridgelabz.greetingapp.models;

public class User {

	public String firstName;
	public String lastName;
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User() {
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.lastName==null ? this.firstName : this.firstName + " " + this.lastName;
	}
}
