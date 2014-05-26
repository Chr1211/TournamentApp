package sum.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sum.model.Match;
import sum.model.Player;
import sum.model.Tournament;

public class TournamentTest {

	private Tournament tournament1;
	private Player player1, player2;
	private Match match1;
	
	@Before
	public void setup(){
		tournament1 = new Tournament("All Stars", null, null);
		player1 = new Player("Emil", "Emil@gmail.com", "10203040", "emil123", true);
		player2 = new Player("Christian", "Christian@gmail.com", "88776655", "Chr123", false);
		match1 = new Match();
		
	}
	@Test
	public void test() {
	}
	
	@Test
	public void testName(){
		
		assertEquals("All Stars",tournament1.getName());
		tournament1.setName("All Stars 6th edition");
		assertEquals("All Stars 6th edition",tournament1.getName());
	}
	
	@Test
	public void testGameMaster(){
		assertEquals(null, tournament1.getGamemaster());
		tournament1.setGamemaster(player1);
		assertEquals( player1, tournament1.getGamemaster());	
	}
	
	@Test
	public void testStartDate(){
		assertEquals(null,tournament1.getStartDate());
		tournament1.setStartDate("20-05-2014");
		assertEquals("20-05-2014",tournament1.getStartDate());
	}
	
	@Test
	public void testGetMatches(){
		assertEquals(0,tournament1.getMatches().size());
		tournament1.getMatches().add(match1);
		assertEquals(1,tournament1.getMatches().size());
	}
	
	@Test
	public void testGetMaches(){
		assertEquals(0,tournament1.getPlayers().size());
		tournament1.getPlayers().add(player1);
		tournament1.getPlayers().add(player2);
		assertEquals(2,tournament1.getPlayers().size());
	}
	
	
}
