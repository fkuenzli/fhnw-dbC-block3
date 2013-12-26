/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, iCompetence
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

public class Coach extends Person {
	private int id;
	private int personID;
	private String education;
	
	public Coach() {
		
	}
	
	public Coach(String firstname, String lastname, String education) {
		super(firstname, lastname);
		this.setEducation(education);
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
	
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

}
