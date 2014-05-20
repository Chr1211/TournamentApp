package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tournament {
	public String name;
	public List<Player> players = new ArrayList<Player>();
	public Date timestamp;
	public List<Match> matches = new ArrayList<Match>();
	public List<Player> gamemasters = new ArrayList<Player>();

	public Tournament(String name, List<Player> players, Date timestamp,
			List<Match> matches, List<Player> gamemasters) {
		super();
		this.name = name;
		this.players = players;
		this.timestamp = timestamp;
		this.matches = matches;
		this.gamemasters = gamemasters;
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

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
