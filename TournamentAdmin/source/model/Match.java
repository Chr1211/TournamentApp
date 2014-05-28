package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
	private List<Player> players = new ArrayList<Player>();
	private boolean done;
	private Player winner;
	private String matchId;
	@SuppressWarnings("unused")
	private int matchNumber;
	
	public Match(List<Player> players, Player winner, boolean done, int matchNumber,
			String matchId) {
		super();
		this.players = players;
		this.winner = winner;
		this.done = done;
		this.matchNumber = matchNumber;
		this.matchId = matchId;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player isWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getmatchId() {
		return matchId;
	}

	public void setmatchId(String matchId) {
		this.matchId = matchId;
	}
	
	public String toString(){
		return "Match Number: " + matchNumber;
	}
	
	
}
