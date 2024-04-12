package test;

import junit.framework.TestCase;
import logic.GameMaster;
import logic.Player;

public class ChangePlayerNameTest extends TestCase {
	
	
	/* Create a player object 
	 * Change the player name with the changeName method
	 * Assert if the name is not null or an empty string after the change
	 */
	public void testPlayerNameChange() {
		Player player = new Player("Peter", true);
		
		String newName = "Marcus";
		player.changeName(newName);
		
		String testValue = player.getName();
		
		assertEquals(newName, testValue);
	}
}
	


