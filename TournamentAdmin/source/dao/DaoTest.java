package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Tournament;

import org.junit.Before;
import org.junit.Test;

public class DaoTest {

	
	private Tournament tournament;

	@Before
	public void setup(){
		ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
		tournament = new Tournament("HenningAllStars", null, null, null, null,1);
	}
	
	@Test
	public void createTournament() {
		Dao dao = new Dao();
		dao.createTournament(tournament);
		//se om tournaments size > 0 
	}

}
