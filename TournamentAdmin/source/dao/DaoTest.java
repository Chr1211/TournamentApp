package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Tournament;

import org.junit.Before;
import org.junit.Test;

public class DaoTest {

	
	private Tournament tournament;

	@Before
	public void setup() throws SQLException{
		@SuppressWarnings("unused")
		ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
		tournament = new Tournament("HenningAllStars", null, null, null, null,null, null, 1);
	}
	
	@Test
	public void createTournament() throws SQLException {
		Dao dao = Dao.getInstance();
		dao.createTournament(tournament);
		//se om tournaments size > 0 
	}

}
