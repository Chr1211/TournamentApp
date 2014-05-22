package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.REUtil;

import model.Player;
import model.Tournament;

public class Dao {

	private Connection connect;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private Player currentlyLoggedIn;
	private ResultSet resultSet = null;
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player loggedInPlayer = null;
	
	public Dao() {
		// TODO Auto-generated constructor stub
	}
	
	public void createTournament(Tournament tournament) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://sighvatur.dk:3306/sumProjekt"
		              , "SumProjekt","4semester");
			prepStatement = connect.prepareStatement("insert into sumProjekt.Tournament values (?, ?, ?, ?, ?)");
			prepStatement.setString(1, tournament.name);
			prepStatement.setString(2, tournament.startDate);
			prepStatement.setString(3, tournament.endDate);
			prepStatement.setString(4, ""+tournament.maxPlayers);
			prepStatement.setString(5, tournament.specialRule);
			prepStatement.executeUpdate();
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
			if(players.size() > 0){
				loggedInPlayer = players.get(0);
				foundPlayer = true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		players = new ArrayList<Player>();
		return foundPlayer;
	}
	
	private void writePlayer(ResultSet resultset) throws SQLException{
		Player foundPlayer = null;
		while(resultset.next()){
			String email = resultset.getString("email");
			String name = resultset.getString("name");
			String phoneNumber = resultset.getString("phoneNumber");
			String password = resultset.getString("password");
			int adminState = resultset.getInt("admin");
			boolean admin = false;
			if(adminState != 0){
				admin = true;
			}
			foundPlayer = new Player(name, email, phoneNumber, password, admin);
			players.add(foundPlayer);
		}
	}
	
	
	

}
