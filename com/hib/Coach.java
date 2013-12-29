/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

public class Coach extends Person {
	private int id;
	private int personID;
	
	public Coach() {
		
	}
	
	public Coach(String firstname, String lastname) {
		super(firstname, lastname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}
}
