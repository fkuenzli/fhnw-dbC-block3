/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2013
 */


package com.hib;

import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		Test tst = new Test();


		tst.addPlayer("Fabian", "Künzli", 999999, 1.78, 67.50, "Flügel");
		
		Fan fan1 = new Fan("Roger", "Gerhard");
		Fan fan2 = new Fan("Heinz", "Kunz");
		
		Coach coach1 = new Coach("Daniel", "Kunz");
		Coach coach2 = new Coach("Markus", "Frauchiger");
		Set<Coach> coaches = new HashSet<Coach>();
		coaches.add(coach1);
		coaches.add(coach2);
		
		Set<Fan> fans = new HashSet<Fan>();
		fans.add(fan1);
		fans.add(fan2);
		
		tst.addTeam("TV Brittnau 1",coaches,fans);
		tst.getTeam(1);
		
	}
	
	private void addTeam(String name, Set<Coach> coaches, Set<Fan> fans) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Team team = new Team(name,coaches);
			team.setFans(fans);

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
	
	private Team getTeam(int teamid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Team team = (Team) session.get(Team.class, teamid);
		
		return team;
	}
	
	private List<Team> getTeams() {
		Transaction trns = null;
		List<Team> teams = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Team as t");
			teams = q.list();
			
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
		
		return teams;
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
	
	private Player getPlayer(int playerid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Player player = (Player) session.get(Player.class, playerid);
		
		return player;
	}
	
	private List<Player> getPlayers() {
		Transaction trns = null;
		List<Player> players = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Player as p");
			players = q.list();
			
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
		
		return players;
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
	
	private Fan getFan(int fanid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Fan fan = (Fan) session.get(Fan.class, fanid);
		
		return fan;
	}
	
	private List<Fan> getFans() {
		Transaction trns = null;
		List<Fan> fans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Fan as f");
			fans = q.list();
			
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
		
		return fans;
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
	
	private Coach getCoach(int coachid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Coach coach = (Coach) session.get(Coach.class, coachid);
		
		return coach;
	}
	
	private List<Coach> getCoaches() {
		Transaction trns = null;
		List<Coach> coaches = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Coach as c");
			coaches = q.list();
			
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
		
		return coaches;
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
	
	private Club getClub(int clubid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Club club = (Club) session.get(Club.class, clubid);
		
		return club;
	}
	
	private List<Club> getClubs() {
		Transaction trns = null;
		List<Club> clubs = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Club as c");
			clubs = q.list();
			
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
		
		return clubs;
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
	
	private Game getGame(int gameid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Game game = (Game) session.get(Game.class, gameid);
		
		return game;
	}
	
	private List<Game> getGames() {
		Transaction trns = null;
		List<Game> games = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Game as g");
			games = q.list();
			
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
		
		return games;
	}
	
	private void addRound(String name, Date startdate, Date enddate, String mode) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			
			Round round = new Round();
			
			round.setName(name);
			round.setStartdate(startdate);
			round.setEnddate(enddate);
			round.setMode(mode);
			
			session.save(round);
			
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
	
	private Round getRound(int roundid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Round round = (Round) session.get(Round.class, roundid);
		
		return round;
	}
	
	private List<Round> getRounds() {
		Transaction trns = null;
		List<Round> rounds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = session.createQuery("from Round as r");
			rounds = q.list();
			
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
		
		return rounds;
	}
}
