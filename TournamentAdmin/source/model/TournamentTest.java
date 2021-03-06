package model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TournamentTest {

	@Test
	public void test() {
	}
	
	@Test
	public void testName() throws SQLException{
		Tournament t = new Tournament("HenningAllStars", null, null, null, null,null, null, 1);
		assertEquals("it fits!", "HenningAllStars", t.getName());
	}
	
	@Test
	public void addPlayers() throws SQLException{
		Player p = new Player("Henning", null, null, null, false);
		List<Player> list = new ArrayList<Player>();
		Tournament t = new Tournament(null, list, null, null, null,null, list, 1);
		assertEquals(0, t.getPlayers().size());
		t.getPlayers().add(p);
		assertEquals(1, t.getPlayers().size());
		
	}
	
	@Test
	public void testTimeStamp(){
		Date time = new Date();
		assertNotNull(time);
	}
//	
//	@Test
//	public void addMatches() throws SQLException{
//		Player p = new Player("Henning", null, null, null, false);
//		Player p2 = new Player("Henriette", null, null, null, false);
//		List<Player> list = new ArrayList<Player>();
//		list.add(p);
//		list.add(p2);
//		Match m = new Match(null, null, false, 1, null);
//		List<Match> matches = new ArrayList<Match>();
//		Tournament t = new Tournament("L", null, null, null, null, matches, null, 2);
//		assertEquals("fits!", 0, t.getMatches().size());
//		t.getMatches().add(m);
//		assertEquals("fits!", 1, t.getMatches().size());
//	}
	@Test
	public void addGameMasters() throws SQLException{
		Player p = new Player("Henning", null, null, null, false);
		List<Player> list = new ArrayList<Player>();
		Tournament t = new Tournament(null, null, null, null, null, null, list,1);
		assertEquals(0, t.getGamemasters().size());
		t.getGamemasters().add(p);
		assertEquals(1, t.getGamemasters().size());
	}
	
	public void testSpecialRule() throws SQLException{
		Tournament t = new Tournament(null, null, null, null, null, null, null, 0);
		assertNull(t.getSpecialRule());
		assertNotNull(t.getSpecialRule());
	}
	
	
	
	

}
