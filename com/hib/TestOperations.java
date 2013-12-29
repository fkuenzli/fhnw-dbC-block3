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



public class TestOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestOperations test = new TestOperations();

		
		/**
		 * add some test records
		 */
		
		test.addClub("Handball Brugg");
		test.addClub("SV Lägern Wettingen");
		test.addClub("TV Brittnau Handball");
		test.addClub("STV Baden");
		
		test.addTeam("Handball Brugg 2");
		test.addTeam("SV Lägern Wettingen 2");
		test.addTeam("TV Brittnau 1");
		test.addTeam("STV Baden 2");
		
		test.addCoach("Oretha","Hendrie");
		test.addCoach("Jennie","Rollison");
		test.addCoach("Jolyn","Fenstermaker");
		test.addCoach("Lucinda","Peet");
		
		test.addFan("Marylin", "Kellar");
		test.addFan("Clayton", "Segers");
		test.addFan("Loise", "Herd");
		test.addFan("Adria", "Shimek");
		test.addFan("Carole", "Farias");
		test.addFan("Hyo", "Southerland");
		test.addFan("Brent", "Sheets");
		test.addFan("Dianne", "Gilligan");
		test.addFan("Zaida", "Begin");
		test.addFan("Jc", "Calcote");
		
		/*
		Team team = test.getTeam(1);
		team.setName("Handball Brugg 1");
		test.updateTeam(team);
		*/
		
	}
	
	/**
	 * @param name
	 */
	private void addTeam(String name) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Team team = new Team(name);

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
	
	/**
	 * @param team
	 * @param club
	 */
	private void addTeamToClub(Team team, Club club) {
		
		club.addTeam(team);
		
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(club);
			
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
	
	/**
	 * @param team
	 * @param game
	 */
	private void addTeamToGame(Team team, Game game) {
		
	}
	
	/**
	 * @param teamid
	 * @return
	 */
	private Team getTeam(int teamid) {
		Transaction trns = null;
		Team team = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			team = (Team) session.get(Team.class, teamid);
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally{
			session.flush();
			session.close();
			
		}
		
		return team;
	}
	
	/**
	 * @return
	 */
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
	
	/**
	 * @param team
	 */
	private void updateTeam(Team team) {
		Transaction trns = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(team);
			
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
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param licenceID
	 * @param height
	 * @param weight
	 * @param mainPosition
	 */
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
	
	/**
	 * @param team
	 * @param player
	 */
	private void addPlayerToTeam(Team team, Player player) {
		
	}
	
	/**
	 * @param playerid
	 * @return
	 */
	private Player getPlayer(int playerid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Player player = (Player) session.get(Player.class, playerid);
		
		return player;
	}
	
	/**
	 * @return
	 */
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
	
	/**
	 * @param player
	 */
	private void updatePlayer(Player player) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(player);
			
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
	
	
	/**
	 * @param firstname
	 * @param lastname
	 */
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
	
	private void addFanToTeam(Fan fan, Team team) {
		
	}
	
	/**
	 * @param fanid
	 * @return
	 */
	private Fan getFan(int fanid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Fan fan = (Fan) session.get(Fan.class, fanid);
		
		return fan;
	}
	
	/**
	 * @return
	 */
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
	
	/**
	 * @param fan
	 */
	private void updateFan(Fan fan) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(fan);
			
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
	
	/**
	 * @param firstname
	 * @param lastname
	 */
	private void addCoach(String firstname, String lastname) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Person person = new Person();
			Coach coach = new Coach();
			
			coach.setPersonID(person.getId());
			coach.setFirstname(firstname);
			coach.setLastname(lastname);

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
	
	/**
	 * @param coach
	 * @param team
	 */
	private void addCoachToTeam(Coach coach, Team team) {
		
		team.addCoach(coach);		
		Transaction trns = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(team);
			
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
	
	/**
	 * @param coachid
	 * @return
	 */
	private Coach getCoach(int coachid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Coach coach = (Coach) session.get(Coach.class, coachid);
		
		return coach;
	}
	
	/**
	 * @return
	 */
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
	
	/**
	 * @param coach
	 */
	private void updateCoach(Coach coach) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(coach);
			
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
	
	
	/**
	 * @param name
	 */
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
	
	/**
	 * @param clubid
	 * @return
	 */
	private Club getClub(int clubid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Club club = (Club) session.get(Club.class, clubid);
		
		return club;
	}
	
	/**
	 * @return
	 */
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
	
	/**
	 * @param club
	 */
	private void updateClub(Club club) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(club);
			
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
	
	/**
	 * @param starttime
	 * @param location
	 */
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
	
	/**
	 * @param game
	 * @param round
	 */
	private void addGameToRound(Game game, Round round) {
		
	}
	

	
	/**
	 * @param gameid
	 * @return
	 */
	private Game getGame(int gameid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Game game = (Game) session.get(Game.class, gameid);
		
		return game;
	}
	
	

	
	/**
	 * @return
	 */
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
	
	/**
	 * @param game
	 */
	private void updateGame(Game game) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(game);
			
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
	
	
	/**
	 * @param name
	 * @param startdate
	 * @param enddate
	 * @param mode
	 */
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

	
	/**
	 * @param roundid
	 * @return
	 */
	private Round getRound(int roundid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Round round = (Round) session.get(Round.class, roundid);
		
		return round;
	}
	
	/**
	 * @return
	 */
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
	
	/**
	 * @param round
	 */
	private void updateRound(Round round) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(round);
			
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
