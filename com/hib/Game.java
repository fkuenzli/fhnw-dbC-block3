/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

import java.util.Date;

public class Game {
	private int id;
	private Date starttime;
	private String location;
	private int teamHomeId;
	private int teamAwayId;
	
	public Game() {
		
	}
	
	public Game(Date starttime, String location) {
		this.starttime = starttime;
		this.location = location;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStartime(Date starttime) {
		this.starttime = starttime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamHomeId() {
		return teamHomeId;
	}

	public void setTeamHomeId(int teamHomeId) {
		this.teamHomeId = teamHomeId;
	}

	public int getTeamAwayId() {
		return teamAwayId;
	}

	public void setTeamAwayId(int teamAwayId) {
		this.teamAwayId = teamAwayId;
	}
	
	
}
