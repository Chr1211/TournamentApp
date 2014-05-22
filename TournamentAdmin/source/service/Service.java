package service;

import java.sql.SQLException;

import dao.Dao;
import model.Player;
import model.Tournament;

public class Service {

	private static Service instance;
	private Dao dao;
	
	private Service() {
		this.dao = new Dao();
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

}
