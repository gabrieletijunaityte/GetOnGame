package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.KilometerCard;
import logic.Player;
import logic.Card;
import logic.Stack;

public class KilometerTest extends TestCase {

	// Test km card creation
	public void testCreationOfKmCard() {
		// Creating a km card
		KilometerCard kmCard = new KilometerCard("FIVE");

		assertNotNull(kmCard);
	}
	
	// Test bully card creation with invalid value
	public void testBadCreationOfKilometerCard() {
		
		try {
			// Creating a bully card
			KilometerCard kmCard = new KilometerCard("BAD_VALUE");
			fail();
		}
		catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "KILOMETER";

		// Creating a km card
		KilometerCard kmCard = new KilometerCard("FIVE");

		// Getting the type
		String test = kmCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "FIVE";

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(target);

		// Getting the type
		String test = kmCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = "FIVE";
		String target1 = "KILOMETER_" + target;

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(target);


		// Testing getCardNameMethod
		String test = kmCard.getCardName();

		assertEquals(target1, test);
	}
	
	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard("FIVE");
		
		// Testing getCardNameMethod
		String test = Arrays.toString(kmCard.getPossibleValues());
		
		assertEquals("[FIVE, SIX, EIGHT, TEN]", test);		
	}
	
	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard("FIVE");
		
		// Testing getAmounts
		String test = Arrays.toString(kmCard.getAmounts());
		
		
		assertEquals("[24, 12, 8, 8]", test);		
	}
	
	// Test isPlayable for false
	public void testIsPlayableFalse() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard("EIGHT");
		// Create player
		Player testPlayer = new Player("Jan", true);
		testPlayer.setOnBikeStatus(true);
		testPlayer.setHasWind(true);
		testPlayer.getPlayedCards().addCard(kmCard);
		testPlayer.getPlayedCards().addCard(kmCard);
		
		// Testing isPlayable
		boolean test = false;
		
		boolean target = kmCard.isPlayable(testPlayer);
				
		assertEquals(target, test);		
	}
	
	//Test isPlayable for true
	public void testIsPlayableTrue() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard("EIGHT");
		// Create player
		Player testPlayer = new Player("Jan", true);
		
		testPlayer.setOnBikeStatus(true);
		testPlayer.setHasWind(true);
		testPlayer.getPlayedCards().addCard(kmCard);
		
		// Testing isPlayable
		boolean test = true;
		
		boolean target = kmCard.isPlayable(testPlayer);
		
		assertEquals(target, test);		
	}

	// test playCard method
	public void testPlayCard() {
		// Create player
		Player testPlayer = new Player("Jan", true);
		
		// Set bikestatus to true so conditions for playing KM card are met
		testPlayer.setOnBikeStatus(true);
		
		// Create discard pile
		Stack discard = new Stack();
		
		// create km card
		KilometerCard kmCard = new KilometerCard("FIVE");
		
		// Play the km card
		kmCard.playCard(testPlayer, discard);
		
		// retrieve km Progress
		int totalKilometers = testPlayer.getKmProgress();
		
		assertEquals(5, totalKilometers);	
	}
	
	// Test getRequirements
	public void testGetRequirements() {
		// Creating a kmCard
		Card kmCard = new KilometerCard("FIVE");
		String [] target = {"true", "false", "-1", "-1", "8"};
		
		// Testing getPossibleValues() method
		String [] test = kmCard.getRequirements();
		
		assertTrue(Arrays.equals(target, test));		
	}
}
