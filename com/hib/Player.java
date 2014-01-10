/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */

package com.hib;

public class Player extends Person {
	
	private int id;
	private int personID;
	private int licenceID;
	private double height;
	private double weight;
	private String mainPosition;
	private int teamID;
	
	public Player() {
		
	}
	
	public Player(String firstname, String lastname) {
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
	
	public int getLicenceID() {
		return licenceID;
	}

	public void setLicenceID(int licenceID) {
		this.licenceID = licenceID;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getMainPosition() {
		return mainPosition;
	}

	public void setMainPosition(String mainPosition) {
		this.mainPosition = mainPosition;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}	
}
