package test;

import junit.framework.TestCase;
import logic.KilometerCard;
import logic.Player;
import logic.Spectator;
import logic.Stack;


/* Create test spectator object
 * use its viewRules() method and store the rules into a test return object
 * print out the return object to visualize the rules
 */
public class SpectatorTest extends TestCase {
	
	public void testViewRules() {
		Spectator testspectator = new Spectator();
		String testReturn = testspectator.viewRules();
		assertNotNull(testReturn);
	}
	
	public void testGetStackSize() {
		// Create a spectator
		Spectator testspectator = new Spectator();
		// Create a current stack
		Stack stackTest = new Stack();
		stackTest.initializeStack();
		
		// Check if the stack is 99
		assertEquals(99, testspectator.getStackSize(stackTest));
	}
	
	public void testGetProgress() {
	    Spectator testspectator = new Spectator();
	    // Null, because it is not supposed to be the spectator's turn
	    Player playerProgress = new Player("John Marston");
	    // Set player and "true" which means you are on a bike
	    playerProgress.setOnBikeStatus(true);
	    KilometerCard fiveKilometerCard = new KilometerCard("FIVE");
	    // Call the five kilometer card
	    playerProgress.playerProgress(fiveKilometerCard.getValue());
	    
	    int expected = 5;
	    int found = testspectator.getProgress(playerProgress);
	    assertEquals(expected, found);
	}
	
	
	
	
	
	
	
}
