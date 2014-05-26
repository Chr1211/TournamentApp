package sum.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

	private List<Player> playerList;
	private Player winner;
	private boolean isDone;
	private String winnerName;
	private String player1Name;
	private String player2Name;
	private String matchNumber;

	public Match() {
		super();
		this.playerList = new ArrayList<Player>();
		this.winner = null;
		this.isDone = false;
	}
	
	public Match(String player1, String player2, String matchNumber){
		winnerName = "noname";
		this.player1Name = player1;
		this.player2Name = player2;
		this.matchNumber = matchNumber;
	}
	
	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

	public Player getWinner() {
		return winner;
	}

	public String getPlayer1Name() {
		return player1Name;
	}

	public String getPlayer2Name() {
		return player2Name;
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
	
	public String toString(){
		return matchNumber + " " + player1Name + " " + player2Name +" " +winnerName;
	}
	
}
