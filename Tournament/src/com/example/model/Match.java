package com.example.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

	private List<Player> players = new ArrayList<Player>();
	private Player winner;
	private Timestamp timestamp;
	private boolean isDone;

	public Match(List<Player> players) {
		super();
		this.players = players;
		this.winner = null;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.isDone = false;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
