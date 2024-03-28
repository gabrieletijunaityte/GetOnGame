package logic;

import junit.framework.TestCase;
import logic.Person.GameMaster;
import logic.Person.Player;
import logic.Person.Spectator;

public class PersonTest extends TestCase {
	
	// testing the creation of person objects
	public void testCreation() {
		Person myName = new Person("Mirte", false);
		assertNotNull(myName);
	}
	
	// testing the name of person objects
	public void testGetName() {
		Person myName = new Person("Mirte", false);
		assertEquals("Mirte", myName.getName());	
	}
	
	// testing the isTurn of person objects
	public void testIsTurn() {
		Person myName = new Person("Mirte", true);
		assertEquals(true, myName.getTurn());
	}
	
	// testing if the subclasses inherent the parameters
	public void testPlayer() {
		Person myName = new Person("Mirte", true);
		Player myPlayer = myName.new Player(myName);
		assertEquals("Mirte", myPlayer.getName());
		assertEquals(true, myPlayer.getTurn());
	}
	
	public void testSpectator() {
		Person myName = new Person("Mirte", true);
		Spectator mySpectator = myName.new Spectator(myName);
		assertEquals("Mirte", mySpectator.getName());
		assertEquals(true, mySpectator.getTurn());
	}
	
	public void testGameMaster() {
		Person myName = new Person("Mirte", true);
		GameMaster myGameMaster = myName.new GameMaster(myName);
		assertEquals("Mirte", myGameMaster.getName());
		assertEquals(true, myGameMaster.getTurn());
	}
	

}
