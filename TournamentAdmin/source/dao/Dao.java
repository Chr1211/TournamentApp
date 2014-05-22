package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Player;
import model.Tournament;

public class Dao {

	private Connection connect;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private Player currentlyLoggedIn;
	
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
	
	public boolean logInPlayer(String email, String password){
		boolean foundPlayer = false;
		String URL = "http://sighvatur.dk/sum/get_single_player.php";
		
		
		
		return foundPlayer;
	}
	
	
	

}
