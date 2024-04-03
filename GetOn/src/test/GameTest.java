package test;

import game.Game;
import junit.framework.TestCase;

public class GameTest extends TestCase {
	
	public void testGameCreation () {
		// Creating game class
		Game game1 = new Game();
		
		// asserting if it was created
		assertNotNull(game1);
	}
	
	

}
