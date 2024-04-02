package test;

import junit.framework.TestCase;
import logic.Spectator;


/* Create test spectator object
 * use its viewRules() method and store the rules into a test return object
 * print out the return object to visualize thge rules
 */
public class SpectatorTest extends TestCase {
	
	public void testViewRules() {
		Spectator testspectator = new Spectator();
		String testReturn = testspectator.viewRules();
		assertNotNull(testReturn);
		System.out.println(testReturn);
	}
}
