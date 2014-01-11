/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

public class Fan extends Person {
	
	private int personID;
	private int teamID;

	public Fan() {
		super();
	}
	
	public Fan(String firstname, String lastname) {
		super(firstname, lastname);
		// TODO Auto-generated constructor stub
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
}
