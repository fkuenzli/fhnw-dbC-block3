/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, iCompetence
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */


package com.hib;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		Test tst = new Test();

		/**
		 * adding records 
		 */
		tst.addUser("Saranga", "Rath");
		tst.addUser("Isuru", "Sampath");
		tst.addUser("Saranga", "Jaya");
		tst.addUser("Prasanna", "Milinda");

		tst.addTask(1, "Call", "Call Pubudu at 5 PM");
		tst.addTask(1, "Shopping", "Buy some foods for Kity"); 
		tst.addTask(2, "Email", "Send birthday wish to Pubudu"); 
		tst.addTask(2, "SMS", "Send message to Dad"); 
		tst.addTask(2, "Office", "Give a call to Boss");


		/**
		 *  retrieving data 
		 */
		tst.getFullName("Saranga");

		/** 
		 * full updating records 
		 */
		User user = new User();
		user.setId(1);
		user.setFirstName("Saranga");
		user.setLastName("Rathnayake");
		tst.updateUser(user);

		/**
		 * partial updating records 
		 */
		tst.updateLastName(3, "Jayamaha");

		/** 
		 * deleting records 
		 */
		User user1 = new User();
		user1.setId(4);
		tst.deleteUser(user1);
	}

	private void addUser(String firstName, String lastName) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			User user = new User();

			user.setFirstName(firstName);
			user.setLastName(lastName);

			session.save(user);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}
	
	private void addTeam(String name) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Team team = new Team();

			team.setName(name);

			session.save(team);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}
	
	private void addPlayer(String firstname, String lastname, int licenceID, double height, double weight, String mainPosition) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			
			Person person = new Person();
			Player player = new Player();

			player.setPersonID(person.getId());
			player.setFirstname(firstname);
			player.setLastname(lastname);
			player.setLicenceID(licenceID);
			player.setHeight(height);
			player.setWeight(weight);
			player.setMainPosition(mainPosition);

			session.save(player);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}
	
	private void addFan(String firstname, String lastname) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Person person = new Person();
			Fan fan = new Fan();

			fan.setPersonID(person.getId());
			fan.setFirstname(firstname);
			fan.setLastname(lastname);

			session.save(fan);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}
	
	private void addCoach(String firstname, String lastname, String education) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Person person = new Person();
			Coach coach = new Coach();
			
			coach.setPersonID(person.getId());
			coach.setFirstname(firstname);
			coach.setLastname(lastname);
			coach.setEducation(education);

			session.save(coach);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}
	
	private void addGame(Date starttime,String location) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Game game = new Game();

			game.setStartime(starttime);
			game.setLocation(location);

			session.save(game);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}
	
	private void addClub(String name) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			
			Club club = new Club();
			
			club.setName(name);
			
			session.save(club);
			
			session.getTransaction().commit();
			
		} catch(RuntimeException e) {
			if(trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			
		}
	}

	private void addTask(int userID, String title, String description) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Task task = new Task();

			task.setUserID(userID);
			task.setTitle(title);
			task.setDescription(description);

			session.save(task);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	}

	private void updateLastName(int id, String lastName) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String hqlUpdate = "update User u set u.lastName = :newLastName where u.id = :oldId";
			int updatedEntities = session.createQuery( hqlUpdate )
					.setString( "newLastName", lastName )
					.setInteger( "oldId", id )
					.executeUpdate();

			trns.commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		}

	}

	private void updateUser(User user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			session.update(user);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		}
	} 

	private void getFullName(String firstName) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			List<User> users = session.createQuery("from User as u where u.firstName = :firstName")
					.setString( "firstName", firstName )
					.list();
			for (Iterator<User> iter = users.iterator(); iter.hasNext();) {
				User user = iter.next();
				System.out.println(user.getFirstName() +" " + user.getLastName());
			}
			trns.commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		} 
	} 

	private void deleteUser(User user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			session.delete(user);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
		}
	} 
}
