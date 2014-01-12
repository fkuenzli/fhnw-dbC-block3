/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

import java.util.Set;
import java.util.HashSet;

public class Coach extends Person {
	private int personID;
	private int level;
	private Set<Team> teams = new HashSet<Team>(0);
	
	public Coach() {
		
	}
	
	public Coach(String firstname, String lastname, int level) {
		super(firstname, lastname);
		this.level = level;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
}
