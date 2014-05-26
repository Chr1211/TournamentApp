package sum.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Tournament {

	private String name;
	private List<Player> playerList;
	private List<Match> matchList;
	private String startDate, endDate;
	private Player gamemaster;

	public Tournament(String name,String startDate, String endDate) {
		super();
		this.name = name;
		this.playerList = new ArrayList<Player>();
		this.matchList = new ArrayList<Match>();
		this.startDate = startDate;
		this.endDate = endDate;
		this.gamemaster = null;
	}
	
	public Tournament(String name, List<Player> playerList,
			List<Match> matchList, String startDate, String endDate,
			Player gamemaster) {
		super();
		this.name = name;
		this.playerList = playerList;
		this.matchList = matchList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.gamemaster = gamemaster;
	}



	public List<Match> getMatchList() {
		return matchList;
	}


	public void setMatchList(List<Match> matchList) {
		this.matchList = matchList;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	
	public String toString(){
		return name;
	}
}
