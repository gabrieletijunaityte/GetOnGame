package test;

import junit.framework.TestCase;
import logic.Spectator;

public class SpectatorTest extends TestCase {
	
	public void testViewRules() {
		Spectator testspectator = new Spectator();
		String testReturn = testspectator.viewRules();
		assertNotNull(testReturn);
		System.out.println(testReturn);
	}
}
