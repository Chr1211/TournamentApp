package dao;

import java.sql.SQLException;

import model.Tournament;

public class tempDao {
	
	public static void main(String[] args) throws SQLException {
		
		Dao dao = new Dao();
		Tournament t = new Tournament("JohnLeague", null, "21-05-2014", "30-05-2014", null, null, 10);
		
		dao.createTournament(t);
		
	}
	
}
