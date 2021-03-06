package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.Service;

public class Tournament {
	private String name, startDate, endDate, specialRule;
	private List<Player> players = new ArrayList<Player>();
	private ArrayList<Match> matches = new ArrayList<Match>();
	private List<Player> gamemasters = new ArrayList<Player>();
	private int maxPlayers;
	@SuppressWarnings("unused")
	private Service service;
	@SuppressWarnings("unused")
	private Player loggedInPlayer;

	public Tournament(String name, List<Player> players, String startDate, String endDate, String specialRule,
			ArrayList<Match> matches, List<Player> gamemasters, int maxPlayers) throws SQLException {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.specialRule = specialRule;
		this.name = name;
		this.players = players;
		this.matches = matches;
		this.gamemasters = gamemasters;
		this.maxPlayers = maxPlayers;
		setUpMatches();
//		service = Service.getInstance();
//		this.loggedInPlayer = service.getLoggedInPlayer();
////		gamemasters.add(loggedInPlayer);
//		service.addPlayerToTournament(loggedInPlayer.getEmail(), this.name, 1);
	}

	public String getSpecialRule() {
		return specialRule;
	}

	public void setSpecialRule(String specialRule) {
		this.specialRule = specialRule;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}

	public List<Player> getGamemasters() {
		return gamemasters;
	}

	public void setGamemasters(List<Player> gamemasters) {
		this.gamemasters = gamemasters;
	}
	
	public String toString(){
		return "Name: " + getName();
	}
	
	public ArrayList<Match> setUpMatches(){
		matches=new ArrayList<>();
		for(int i = 0; i < 7; i++){
			matches.add(new Match(null, null, false,i+1, null));
		}
		
		return matches;
	}


}
