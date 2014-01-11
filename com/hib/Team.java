/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

import java.util.HashSet;
import java.util.Set;

public class Team {
	private int id;
	private String name;
	private int clubID;
	private Set<Fan> fans = new HashSet<Fan>(0);
	private Set<Coach> coaches = new HashSet<Coach>(0);
	
	public Team() {
		
	};
	
	public Team(String name) {
		this.name = name;
	}
	
	public Team(String name, Set<Coach> coaches) {
		this.name = name;
		this.setCoaches(coaches);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Fan> getFans() {
		return fans;
	}

	public void setFans(Set<Fan> fans) {
		this.fans = fans;
	}
	
	public void addFan(Fan fan) {
		this.fans.add(fan);
	}

	public Set<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(Set<Coach> coaches) {
		this.coaches = coaches;
	}
	
	public void addCoach(Coach coach) {
		this.coaches.add(coach);
	}

	public int getClubID() {
		return clubID;
	}

	public void setClubID(int clubID) {
		this.clubID = clubID;
	}
}
