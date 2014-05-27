package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Tournament;

public class Dao {

	private Connection connect;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private ResultSet resultSet = null;
	private ArrayList<Player> players;
	private ArrayList<Tournament> tournaments;
	private ArrayList<Tournament> loggedInTournaments;
	private Player loggedInPlayer = null;
	private static Dao daoInstance;
	
	
	private Dao() {
		this.players = new ArrayList<Player>();
		this.tournaments = new ArrayList<Tournament>();
	}
	
	public static Dao getInstance(){
		if(daoInstance == null){
			daoInstance = new Dao();
		}
		return daoInstance;
	}
	
	public void createTournament(Tournament tournament) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt"
		              , "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("insert into sumProjekt.Tournament values (?, ?, ?, ?, ?)");
			prepStatement.setString(1, tournament.getName());
			prepStatement.setString(2, tournament.getStartDate());
			prepStatement.setString(3, tournament.getEndDate());
			prepStatement.setString(4, ""+tournament.getMaxPlayers());
			prepStatement.setString(5, tournament.getSpecialRule());
			prepStatement.executeUpdate();
			
			for (int i=1; i<=7; i++) {
				String sql="INSERT INTO `Match`(`player1Email`, `player2Email`, `tournamentName`, `emailWinner`, `done`, `MatchNumber`, `dato`) VALUES ('NoPlayer','NoPlayer','" + tournament.getName() + "', '',0," + i + ",'')";
				statement = connect.createStatement();
				statement.execute(sql);						
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		prepStatement.close();
	}
	
	public void createPlayer(Player player) throws SQLException{
		String admin = "0";
		if(player.isAdmin()){
			admin = "1";
		} 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("insert into sumProjekt.Player values (?, ?, ?, ?, ?)");
			prepStatement.setString(1, player.getEmail());
			prepStatement.setString(2, player.getName());
			prepStatement.setString(3, player.getPhoneNumber());
			prepStatement.setString(4, player.getPassword());
			prepStatement.setString(5, admin);
			prepStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		prepStatement.close();
		
	}
	
	public boolean logInPlayer(String email, String password) throws SQLException{
		boolean foundPlayer = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("SELECT * FROM Player WHERE email =? AND password=?");
			prepStatement.setString(1, email);
			prepStatement.setString(2, password);
			resultSet = prepStatement.executeQuery();
			writePlayer(resultSet);
			System.out.println(players.size());
			if(players.size() > 0){
				loggedInPlayer = players.get(0);
				foundPlayer = true;
				System.out.println(loggedInPlayer);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connect.close();
		prepStatement.close();
		players = new ArrayList<Player>();
		return foundPlayer;
	}
	
	public Player getLoggedInPlayer() {
		return loggedInPlayer;
	}

	public void setLoggedInPlayer(Player loggedInPlayer) {
		this.loggedInPlayer = loggedInPlayer;
	}

	private void writePlayer(ResultSet resultSet) throws SQLException{
		Player foundPlayer = null;
		
		while(resultSet.next()){
			String email = resultSet.getString("email");
			String name = resultSet.getString("name");
			String phoneNumber = resultSet.getString("phoneNumber");
			String password = resultSet.getString("password");
			int adminState = resultSet.getInt("admin");
			boolean admin = false;
			if(adminState != 0){
				admin = true;
			}
			foundPlayer = new Player(name, email, phoneNumber, password, admin);
			players.add(foundPlayer);
		}
	}
	
	private void writeTournament(ResultSet resultSet) throws SQLException{
		Tournament foundTournament = null;
		while(resultSet.next()){
			String name = resultSet.getString("name");
			String startDate = resultSet.getString("startDate");
			String endDate = resultSet.getString("endDate");
			int maxPlayers = resultSet.getInt("maxPlayers");
			String specialRule = resultSet.getString("variables");
			
			foundTournament = new Tournament(name, null, startDate, endDate, specialRule, null, null, maxPlayers);
			tournaments.add(foundTournament);
		}
	}
	
	private void writeLoggedTournament(ResultSet resultSet) throws SQLException{
		Tournament foundTournament = null;
		while(resultSet.next()){
			String name = resultSet.getString("name");
			String startDate = resultSet.getString("startDate");
			String endDate = resultSet.getString("endDate");
			int maxPlayers = resultSet.getInt("maxPlayers");
			String specialRule = resultSet.getString("variables");
			
			foundTournament = new Tournament(name, null, startDate, endDate, specialRule, null, null, maxPlayers);
			loggedInTournaments.add(foundTournament);
		}
	}
	
	
	public void loadPlayers() throws SQLException{
		players=new ArrayList<Player>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			statement= connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM sumProjekt.Player");
			writePlayer(resultSet);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		statement.close();
	}
	
	public void loadTournaments() throws SQLException{
		tournaments = new ArrayList<Tournament>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM sumProjekt.Tournament");
			writeTournament(resultSet);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		statement.close();
	}
	
	public ArrayList<Player> getPlayers() throws SQLException{
		System.out.println(players);
		return players;
	}
	
	public ArrayList<Tournament> getTournaments(){
		return tournaments;
	}
	
	public void updatePlayer(String name, String email, String phoneNumber, String password) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("UPDATE sumProjekt.Player SET email=?, name=?, phoneNumber=?, password=? WHERE email =?");
			prepStatement.setString(1, email);
			prepStatement.setString(2, name);
			prepStatement.setString(3, phoneNumber);
			prepStatement.setString(4, password);
			prepStatement.setString(5, email);
			prepStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		prepStatement.close();
		
	}
	
	public void updateTournament(String name, String startDate, String endDate, int maxPlayers, String specialRule) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("UPDATE sumProjekt.Tournament SET name=?, startDate=?, endDate=?, maxPlayers=?, variables=? WHERE name=?");
			prepStatement.setString(1, name);
			prepStatement.setString(2, startDate);
			prepStatement.setString(3, endDate);
			prepStatement.setString(4, maxPlayers+"");
			prepStatement.setString(5, specialRule);
			prepStatement.setString(6, name);
			prepStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		prepStatement.close();
	}
	
	public void addPlayerToTournament(String email, String name, int gamemaster) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("insert into sumProjekt.TournamentPlayer values (?, ?, ?, 1)");
			prepStatement.setString(1, email);
			prepStatement.setString(2, name);
			prepStatement.setString(3, gamemaster+"");
			prepStatement.executeUpdate();
			prepStatement.close();

			boolean found=false;
			
			String sql="SELECT `player1Email`, `player2Email`, `MatchNumber` FROM `Match` WHERE `MatchNumber`<5 and `tournamentName`='"+name+"'";
			System.out.println(sql);
			statement = connect.createStatement();
			resultSet=statement.executeQuery(sql);
			String noPlayer="NoPlayer";
			String playerEmail="";
			
			while (resultSet.next() && !found) {
				String p1=resultSet.getString("player1Email");
				String p2=resultSet.getString("player2Email");
				
				
				
				int matchNumber = resultSet.getInt("MatchNumber");
				if (p1.equals(noPlayer)) {
					playerEmail="player1Email";
					found=true;
				} 
				else if (p2.equals(noPlayer)) {
					playerEmail="player2Email";
					found=true;
				}
				
				if (found) {
					System.out.println("true");
					System.out.println(name + " " + matchNumber);
					prepStatement=connect.prepareStatement("UPDATE `Match` SET "+ playerEmail + "=? WHERE `tournamentName`=? AND `MatchNumber`=?");
					prepStatement.setString(1, email);
					prepStatement.setString(2, name);
					prepStatement.setString(3, matchNumber+"");
					prepStatement.execute();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prepStatement.close();
		connect.close();
		
		
	}
	
	public void findLoggedInTournaments() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("SELECT T.name, T.startDate, T.endDate, T.maxPlayers, T.variables FROM  `TournamentPlayer` TP,  `Tournament` T WHERE TP.name = T.name AND TP.email =? AND TP.gamemaster = 1");
			prepStatement.setString(1, loggedInPlayer.getEmail());
			resultSet = prepStatement.executeQuery();
			writeLoggedTournament(resultSet);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
		prepStatement.close();
	}
	
	public ArrayList<Tournament> getAllLoggedInTournaments(){
		return loggedInTournaments;
	}
	
	public List<Player> getPlayersNotInTournament(String name) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
		List<Player> players=new ArrayList<>();
		prepStatement=connect.prepareStatement("SELECT p.email, p.name FROM  `Player` p WHERE p.email NOT IN (SELECT email FROM  `TournamentPlayer` WHERE name =?)");
		prepStatement.setString(1, name);
		resultSet=prepStatement.executeQuery();
		while (resultSet.next()) {
			Player p=new Player(resultSet.getString("name"), resultSet.getString("email"), null, null, false);
			players.add(p);
		}
		
		return players;
	}
	
	public List<Player> getPlayersInTournament(String name) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt", "SumProjekt","4semester");
		List<Player> players=new ArrayList<>();
		prepStatement=connect.prepareStatement("SELECT p.email, p.name FROM `Player` p, `TournamentPlayer` tp where tp.name=? and tp.email=p.email");
		prepStatement.setString(1, name);
		resultSet=prepStatement.executeQuery();
		while (resultSet.next()) {
			Player p=new Player(resultSet.getString("name"), resultSet.getString("email"), null, null, false);
			players.add(p);
		}
		
		return players;
	}
}
