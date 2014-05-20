package sum.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sum.model.Player;

public class PlayerTest {

	private Player player1, player2;
	
	@Before
	public void setup(){
		player1 = new Player("Emil", "Emil@gmail.com", "10203040", "emil123", true);
		
	}
	@Test
	public void test() {
	}
	
	@Test
	public void testName(){
		assertEquals("Emil", player1.getName());
		player1.setName("Christian");
		assertEquals("Christian", player1.getName());
	}
	
	@Test
	public void testEmail(){
		assertEquals("Emil@gmail.com", player1.getEmail());
		player1.setEmail("Chr@gmail.com");
		assertEquals("Chr@gmail.com", player1.getEmail());
	}
	
	@Test
	public void testPhonenumber(){
		assertEquals("10203040",player1.getPhonenumber());
		player1.setPhonenumber("12345678");
		assertEquals("12345678",player1.getPhonenumber());
	}
	
	@Test
	public void testPassword(){
		assertEquals("emil123",player1.getPassword());
		player1.setPassword("emil321");
		assertEquals("emil321",player1.getPassword());
	}
	
	@Test
	public void testIsAdmin(){
		assertEquals(true, player1.isAdmin());
		player1.setAdmin(false);
		assertEquals(false, player1.isAdmin());
	}
}
