/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, iCompetence
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

public class Fan extends Person {
	
	private int id;
	private int personID;
	private int fanSince;

	public Fan() {
		super();
	}
	
	public Fan(String firstname, String lastname) {
		super(firstname, lastname);
		// TODO Auto-generated constructor stub
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
	
	public int getFanSince() {
		return fanSince;
	}

	public void setFanSince(int fanSince) {
		this.fanSince = fanSince;
	}

}
