package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
	public List<Player> players = new ArrayList<Player>();
	public boolean winner, done;
	public Date timestamp;
	
	public Match(List<Player> players, boolean winner, boolean done,
			Date timestamp) {
		super();
		this.players = players;
		this.winner = winner;
		this.done = done;
		this.timestamp = timestamp;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
