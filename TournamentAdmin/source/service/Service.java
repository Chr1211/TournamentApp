package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;
import model.Player;
import model.Tournament;

public class Service {

	private static Service instance;
	private Dao dao;
	
	private Service() {
		this.dao = Dao.getInstance();
	}
	
	public static Service getInstance(){
		if(instance == null){
			instance = new Service();
		}
		return instance;
	}
	
	public void createNewTournament(String name, String startDate, String endDate,String specialRule, String maxPlayers) throws SQLException{
		Tournament tournament = new Tournament(name, null, startDate, endDate, specialRule, null, null, Integer.parseInt(maxPlayers));
		dao.createTournament(tournament);
	}
	
	public void createNewPlayer(String email, String name, String phoneNumber, String password, boolean admin) throws SQLException{
		Player player = new Player(name, email, phoneNumber, password, admin);
		dao.createPlayer(player);
	}
	
	public boolean logInPlayer(String email, String password) throws SQLException{
		return dao.logInPlayer(email, password);
	}
	
	public ArrayList<Player> getAllPlayers() throws SQLException{
		return dao.getPlayers();
	}
	
	public void loadPlayers() throws SQLException{
		dao.loadPlayers();
	}
	
	public void updatePlayer(String name, String email, String phoneNumber, String password) throws SQLException{
		dao.updatePlayer(name, email, phoneNumber, password);
	}

}
