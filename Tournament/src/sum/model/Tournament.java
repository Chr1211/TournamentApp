package sum.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Tournament {

	private String name;
	private List<Player> playerList;
	private List<Match> matchList;
	private String startDate;
	private Player gamemaster;

	public Tournament(String name, Player gamemaster) {
		super();
		this.name = name;
		this.playerList = new ArrayList<Player>();
		this.matchList = new ArrayList<Match>();
		this.startDate = null;
		this.gamemaster = gamemaster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getGamemaster() {
		return gamemaster;
	}

	public void setGamemaster(Player gamemaster) {
		this.gamemaster = gamemaster;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public List<Match> getMatches() {
		return matchList;
	}

	public List<Player> getPlayers() {
		return playerList;
	}
}
