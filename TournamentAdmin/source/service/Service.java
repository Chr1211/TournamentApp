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
		dao.getLoggedInPlayer().getEmail();
		addPlayerToTournament(dao.getLoggedInPlayer().getEmail(), name, 1);
		
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
	
	public ArrayList<Tournament> getAllTournaments(){
		return dao.getTournaments();
	}
	
	public void loadPlayers() throws SQLException{
		dao.loadPlayers();
	}
	
	public void loadTournaments() throws SQLException{
		dao.loadTournaments();
	}
	
	public void updatePlayer(String name, String email, String phoneNumber, String password) throws SQLException{
		dao.updatePlayer(name, email, phoneNumber, password);
	}
	
	public void updateTournament(String name, String startDate, String endDate,int maxPlayers, String specialRule) throws SQLException{
		dao.updateTournament(name, startDate, endDate, maxPlayers, specialRule);
	}
	
	public Player getLoggedInPlayer(){
		return dao.getLoggedInPlayer();
	}
	
	public void addPlayerToTournament(String email, String name, int gamemaster) throws SQLException{
		dao.addPlayerToTournament(email, name, gamemaster);
	}
	
	public void loggedInTournaments() throws SQLException{
		dao.findLoggedInTournaments();
	}
	
	public ArrayList<Tournament> getAllLoggedTournaments(){
		return dao.getAllLoggedInTournaments();
	}

}
