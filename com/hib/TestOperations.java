/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */


package com.hib;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class TestOperations {
	
	private static TestOperations usecase = new TestOperations();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addTestData();
		usecase1();
		usecase2();
		usecase3();
		usecase4();
	}
	
	
	/**
	 * Weise einem Team Coaches, Spieler und Fans zu und teile das Team es einem bestehenden Club zu.
	 */
	private static void usecase1() {
		Team team = usecase.getTeamById(1);
		
		Coach coach = usecase.getCoachById(1);
		usecase.addCoachToTeam(coach, team);
		
		coach = usecase.getCoachById(2);
		usecase.addCoachToTeam(coach, team);
		
		usecase.addPlayerToTeam(team, 15);
		usecase.addPlayerToTeam(team, 16);
		usecase.addPlayerToTeam(team, 17);
		usecase.addTeamToClub(1, 1);
		
		Fan fan = usecase.getFanByName("Marylin", "Kellar");
		usecase.addFanToTeam(fan, team);
		
		fan = usecase.getFanByName("Clayton", "Segers");
		usecase.addFanToTeam(fan, team);
		
		fan = usecase.getFanByName("Loise", "Herd");
		usecase.addFanToTeam(fan, team);
		
		fan = usecase.getFanByName("Adria", "Shimek");
		usecase.addFanToTeam(fan, team);
		
	}
	
	/**
	 * Lösche einen Coach von einem Team und weise einen neuen zu.
	 */
	private static void usecase2() {
		Team team = usecase.getTeamById(1);

		Coach coachOld = usecase.getCoachById(1);
		Coach coachNew = usecase.getCoachById(3);
		
		usecase.removeCoachFromTeam(coachOld, team);
		usecase.addCoachToTeam(coachNew, team);
	}
	
	
	/**
	 * Liste alle Spieler von [team] auf.
	 */
	private static void usecase3() {
		
		Team team = usecase.getTeamById(2);
		
		List<Player> players = usecase.getPlayersOfSpecificTeam(team);
		Player player = null;
		for(Iterator<Player> i = players.iterator(); i.hasNext();) {
			player = i.next();
			System.out.println(player.getLicenceID() + " " + player.getFirstname() + " " + player.getLastname());
		}		
	}
	
	/**
	 * Ändere den Clubnamen.
	 */
	private static void usecase4() {
		Club club = usecase.getClubByName("TV Brittnau Handball");
		
		usecase.changeNameOfClub(club, "HV Brittnau");		
	}
	
	private static void addTestData() {
		/**
		 * Create statements
		 */
		
		usecase.addClub("Handball Brugg");
		usecase.addClub("SV Lägern Wettingen");
		usecase.addClub("TV Brittnau Handball");
		usecase.addClub("STV Baden");
		
		usecase.addTeam("Handball Brugg 2");
		usecase.addTeam("SV Lägern Wettingen 2");
		usecase.addTeam("TV Brittnau 1");
		usecase.addTeam("STV Baden 2");
		
		usecase.addCoach("Oretha","Hendrie",5);
		usecase.addCoach("Jennie","Rollison",2);
		usecase.addCoach("Jolyn","Fenstermaker",2);
		usecase.addCoach("Lucinda","Peet",4);
		
		usecase.addFan("Marylin", "Kellar");
		usecase.addFan("Clayton", "Segers");
		usecase.addFan("Loise", "Herd");
		usecase.addFan("Adria", "Shimek");
		usecase.addFan("Carole", "Farias");
		usecase.addFan("Hyo", "Southerland");
		usecase.addFan("Brent", "Sheets");
		usecase.addFan("Dianne", "Gilligan");
		usecase.addFan("Zaida", "Begin");
		usecase.addFan("Jc", "Calcote");
			
		usecase.addPlayer("Steven", "Hunter", 395067, 1.81, 78, "Flügel links");
		usecase.addPlayer("Larry", "Zimmerman", 532373, 1.98, 101, "Rückraum links");
		usecase.addPlayer("Darnell", "Garza", 712573, 1.71, 70, "Hinten mitte");
		usecase.addPlayer("Noah", "Cole", 143280, 1.88, 93, "Rückraum rechts");
		usecase.addPlayer("Floyd", "Mckinney", 487733, 1.91, 95, "Kreis");
		usecase.addPlayer("Peter", "Estrada", 360103, 1.77, 65, "Rückraum links");
		usecase.addPlayer("Woodrow", "Cross", 613561, 1.73, 63, "Flügel rechts");
		usecase.addPlayer("Kelly", "Jensen", 386101, 1.98, 92, "Rückraum rechts");
		usecase.addPlayer("Shawn", "Cook", 136187, 1.92, 90, "Rückraum links");
		usecase.addPlayer("Cedric", "Soto", 334343, 1.69, 69, "Flügel links");
		
				
		usecase.addTeamToClub(2,2);
		usecase.addPlayerToTeam(2, 18);
		usecase.addPlayerToTeam(2, 19);
		usecase.addFanToTeam(usecase.getFanById(8), usecase.getTeamById(2));
		usecase.addFanToTeam(usecase.getFanById(9), usecase.getTeamById(2));
		usecase.addFanToTeam(usecase.getFanById(10), usecase.getTeamById(2));
		usecase.addFanToTeam(usecase.getFanById(11), usecase.getTeamById(2));
		
		usecase.addTeamToClub(3,3);
		usecase.addPlayerToTeam(3, 20);
		usecase.addPlayerToTeam(3, 21);
		usecase.addPlayerToTeam(3, 22);	
		
		usecase.addTeamToClub(4,4);
		usecase.addPlayerToTeam(4, 23);
		usecase.addPlayerToTeam(4, 24);
		
		
		usecase.addRound("Vorrunde", new GregorianCalendar(2013,9,7), new GregorianCalendar(2013,12,14), "2 Aufsteiger, 2 Absteiger");
		
		usecase.addGame(new GregorianCalendar(2013,9,7,13,15,0), "Klingnau Schützenmatt",1); 
		usecase.addGame(new GregorianCalendar(2013,9,7,16,30,0), "Wohlen Hofmatten",1);
		usecase.addGame(new GregorianCalendar(2013,9,7,20,15,0), "Zofingen BZZ",1);
		usecase.addGame(new GregorianCalendar(2013,9,14,15,0,0), "Buchs Suhrenmatte",1);
		usecase.addGame(new GregorianCalendar(2013,9,14,15,15,0), "Schöftland SPH",1);
		usecase.addGame(new GregorianCalendar(2013,9,14,17,30,0), "Klingnau Schützenmatt",1);
		
		usecase.addHomeTeamToGame(1, 1);
		usecase.addAwayTeamToGame(1, 2);
		usecase.addHomeTeamToGame(2, 3);
		usecase.addAwayTeamToGame(2, 4);
		usecase.addHomeTeamToGame(3, 1);
		usecase.addAwayTeamToGame(3, 3);
		usecase.addHomeTeamToGame(4, 2);
		usecase.addAwayTeamToGame(4, 4);
		usecase.addHomeTeamToGame(5, 1);
		usecase.addAwayTeamToGame(5, 4);
		usecase.addHomeTeamToGame(6, 2);
		usecase.addAwayTeamToGame(6, 3);
		
		
		usecase.addGameToRound(1, 1);
		usecase.addGameToRound(2, 1);
		usecase.addGameToRound(3, 1);
		usecase.addGameToRound(4, 1);
		usecase.addGameToRound(5, 1);
		usecase.addGameToRound(6, 1);
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
	
	private void addTeamToClub(int clubid, int teamid) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Team team = (Team)session.get(Team.class,teamid);
			team.setClubID(clubid);

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
	 * @param teamid
	 * @return
	 */
	private Team getTeamById(int teamid) {
		Transaction trns = null;
		Team team = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			team = (Team) session.get(Team.class, teamid);
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
		
		return team;
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
			
			Player player = new Player();

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
	 * 
	 * @param team
	 * @param playerid
	 */
	private void addPlayerToTeam(Team team, int playerid) {
		int teamid = team.getId();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Player player = (Player)session.get(Player.class,playerid);
			player.setTeamID(teamid);

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
	 * 
	 * @param teamid
	 * @param playerid
	 */
	private void addPlayerToTeam(int teamid, int playerid) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Player player = (Player)session.get(Player.class,playerid);
			player.setTeamID(teamid);

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
	 * 
	 * @param team
	 * @return
	 */
	private List<Player> getPlayersOfSpecificTeam(Team team) {
		
		int teamid = team.getId();
		
		Transaction trns = null;
		List<Player> players = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q =	session.createQuery("from Player as p where p.teamID = " + teamid);
			
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
	 * @param firstname
	 * @param lastname
	 */
	private void addFan(String firstname, String lastname) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Fan fan = new Fan();

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
	
	/**
	 * 
	 * @param fan
	 * @param team
	 */
	private void addFanToTeam(Fan fan, Team team) {
		team.getFans().add(fan);
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
	 * 
	 * @param fanid
	 * @return
	 */
	private Fan getFanById(int fanid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Fan fan = (Fan) session.get(Fan.class, fanid);
		
		return fan;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	private Fan getFanByName(String firstname, String lastname) {
		Transaction trns = null;
		Fan fan = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = 	session.createQuery("from Fan as fan where fan.firstname = :firstname and fan.lastname = :lastname")
						.setString("firstname", firstname)
						.setString("lastname",lastname)
						.setMaxResults(1);
			
			List<Fan> fans = q.list();
			
			for(Iterator<Fan> i = fans.iterator(); i.hasNext();) {
				fan = i.next();
			}
			
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
		
		return fan;
	}
	
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param level
	 */
	private void addCoach(String firstname, String lastname, int level) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Coach coach = new Coach();
			
			coach.setFirstname(firstname);
			coach.setLastname(lastname);
			coach.setLevel(level);

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
		team.getCoaches().add(coach);
		Transaction trns = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(team);
			
			session.getTransaction().commit();
			
			System.out.println("Sucessfully added coach to team.");
			
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
	 * 
	 * @param coach
	 * @param team
	 */
	private void removeCoachFromTeam(Coach coach, Team team) {
		team.getCoaches().remove(coach);
		System.out.println(coach.getFirstname());
		Transaction trns = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(team);
			
			session.getTransaction().commit();
			System.out.println("Sucessfully removed coach from team.");
			
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
	private Coach getCoachById(int coachid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Coach coach = (Coach) session.get(Coach.class, coachid);
		
		return coach;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	private Coach getCoachByName(String firstname, String lastname) {
		Transaction trns = null;
		Coach coach = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = 	session.createQuery("from Coach as coach where coach.firstname = :firstname and coach.lastname = :lastname")
						.setString("firstname", firstname)
						.setString("lastname",lastname)
						.setMaxResults(1);
			
			List<Coach> coaches = q.list();
			
			for(Iterator<Coach> i = coaches.iterator(); i.hasNext();) {
				coach = i.next();
			}
			
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
		
		return coach;
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
	private Club getClubById(int clubid) {
		Transaction trns = null;
		Club club = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			club = (Club) session.get(Club.class, clubid);
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
		
		return club;
	}
	
	/**
	 * @param name
	 * @return
	 */
	private Club getClubByName(String name) {
		Transaction trns = null;
		Club club = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			Query q = 	session.createQuery("from Club as club where club.name = :name")
						.setString("name", name)
						.setMaxResults(1);
			
			List<Club> clubs = q.list();
			
			for(Iterator<Club> i = clubs.iterator(); i.hasNext();) {
				club = i.next();
			}
			
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
		
		return club;
	}
	
	/**
	 * 
	 * @param club
	 * @param name
	 */
	private void changeNameOfClub(Club club, String name) {
		
		club.setName(name);
		
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			
			session.update(club);
			
			session.getTransaction().commit();
			
			System.out.println("Club name was successfully changed to " + name);
			
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
	 * 
	 * @param starttime
	 * @param location
	 * @param roundID
	 */
	private void addGame(GregorianCalendar starttime,String location, int roundID) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Game game = new Game();

			game.setStarttime(starttime);
			game.setLocation(location);
			game.setRoundID(roundID);

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
	 * 
	 * @param gameid
	 * @param teamid
	 */
	private void addHomeTeamToGame(int gameid, int teamid) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Game game = (Game)session.get(Game.class,gameid);
			game.setTeamHomeId(teamid);

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
	
	private void addAwayTeamToGame(int gameid, int teamid) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Game game = (Game)session.get(Game.class,gameid);
			game.setTeamAwayId(teamid);

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
	 * 
	 * @param gameID
	 * @param roundID
	 */
	private void addGameToRound(int gameID, int roundID) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Game game = (Game)session.get(Game.class,roundID);
			game.setRoundID(roundID);

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
	 * @param gameid
	 * @return
	 */
	private Game getGameById(int gameid) {
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
	 * 
	 * @param name
	 * @param startdate
	 * @param enddate
	 * @param mode
	 */
	private void addRound(String name, GregorianCalendar startdate, GregorianCalendar enddate, String mode) {
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
}
