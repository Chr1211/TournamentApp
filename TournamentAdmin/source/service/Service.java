package service;

import java.sql.SQLException;

import dao.Dao;
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
	
	public void createNewTournament(String name, String startDate, String endDate,String maxPlayers) throws SQLException{
		Tournament tournament = new Tournament(name, null, startDate, endDate, null, null, Integer.parseInt(maxPlayers));
		dao.createTournament(tournament);
	}

}
