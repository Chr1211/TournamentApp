package sum.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sum.model.Match;
import sum.model.Player;

public class MatchTest {
	
	private Player player1, player2;
	private Match match1;
	
	@Before
	public void setup(){
		player1 = new Player("Emil", "Emil@gmail.com", "10203040", "emil123", true);
		player2 = new Player("Christian", "Christian@gmail.com", "88776655", "Chr123", false);
		match1 = new Match();
		
		match1.getPlayers().add(player1);
		match1.getPlayers().add(player2);
		
	}
	@Test
	public void test() {
	}
	
	@Test
	public void testWinner(){
		assertEquals(null,match1.getWinner());
		match1.setWinner(player1);
		assertEquals(player1, match1.getWinner());
	}
	
	@Test
	public void testIsDone(){
		assertEquals(false, match1.isDone());
		match1.setDone(true);
		assertEquals(true, match1.isDone());
	}
	
	@Test
	public void testGetPlayers(){
		assertEquals(2, match1.getPlayers().size());
		match1.getPlayers().remove(1);
		assertEquals(1, match1.getPlayers().size());
	}
	
	
	
}
