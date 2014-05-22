package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tournament {
	public String name, startDate, endDate;
	public List<Player> players = new ArrayList<Player>();
	public List<Match> matches = new ArrayList<Match>();
	public List<Player> gamemasters = new ArrayList<Player>();
	public int maxPlayers;

	public Tournament(String name, List<Player> players, String startDate, String endDate,
			List<Match> matches, List<Player> gamemasters, int maxPlayers) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.players = players;
		this.matches = matches;
		this.gamemasters = gamemasters;
		this.maxPlayers = maxPlayers;
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

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public List<Player> getGamemasters() {
		return gamemasters;
	}

	public void setGamemasters(List<Player> gamemasters) {
		this.gamemasters = gamemasters;
	}
	
	

}
