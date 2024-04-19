package test;

import java.util.Arrays;


import junit.framework.TestCase;
import logic.Rules;
import logic.Player;
import logic.Card;
import logic.StatusCard;
import logic.KilometerCard;

public class RulesTest extends TestCase {

	// Testing the creation of the default rule object
	public void testRuleCreation() {
		
		Rules defaultRule = new Rules();
		assertNotNull(defaultRule);
		
	}
	
	// Testing the retrieving of the default rule object
	public void testGetRules() {
		
		Rules defaultRule = new Rules();
		String returned = defaultRule.getRules();
		assertNotNull(returned);
		
	}
	
	// Check if the card is playble caseA (kmCard with requirement for wind)
	public void testIsPlaybleCaseA() {
		Rules rules = new Rules();
		
		// Define required attributes
		Card kmCard = new KilometerCard("EIGHT");
		Player testPlayer = new Player("Jan");
		
		// Set Statuses for player to be able to play the card
		testPlayer.setOnBikeStatus(true);
		testPlayer.setHasWind(true);
		
		
		// Defining test variables
		Boolean target = true;
		Boolean test = rules.isPlayble(kmCard, testPlayer);
		
		assertEquals(target, test);
	}
	
	// Check if the card is playble caseB (GET_ON with requirement for noBully)
	public void testIsPlaybleCaseB() {
		Rules rules = new Rules();
		
		// Define required attributes
		Card statusCard = new StatusCard("GET_ON");
		Player testPlayer = new Player("Jan");
		
		// Defining test variables
		Boolean target = true;
		Boolean test = rules.isPlayble(statusCard, testPlayer);
		
		assertEquals(target, test);
	}

	
}
