package com.example.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Tournament {

	private String name;
	private List<Player> playerList;
	private List<Match> matches;
	private Timestamp timestamp;
	private Player gamemaster;

	public Tournament(String name, Player gamemaster) {
		super();
		this.name = name;
		this.playerList = new ArrayList<Player>();
		this.matches = new ArrayList<Match>();
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.gamemaster = gamemaster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public Player getGamemaster() {
		return gamemaster;
	}

	public void setGamemaster(Player gamemaster) {
		this.gamemaster = gamemaster;
	}

}
