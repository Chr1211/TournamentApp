package sum.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

	private List<Player> playerList;
	private Player winner;
	private boolean isDone;

	public Match() {
		super();
		this.playerList = new ArrayList<Player>();
		this.winner = null;
		this.isDone = false;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public List<Player> getPlayers(){
		return playerList;
	}
}
