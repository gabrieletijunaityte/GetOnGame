package test;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;
import logic.Card;
import logic.Hand;
import logic.KilometerCard;
import logic.PlayerTable;
import logic.Player;
import logic.Stack;

public class PlayerTest extends TestCase {

	// Test Player creation
	public void testPlayerCreation() {
		// Create a player
		Player testPlayer = new Player("Jan", true);

		// assert that the object was created
		assertNotNull(testPlayer);
	}

	// Test hand creation
	public void testCreateHand() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan", true);
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.hand.fillHand(stack, 5);

		// Test if 5 cards were drawn
		assertEquals(5, myPlayer.hand.getHand().size());
		//System.out.println(myPlayer.hand.getHand().toString());

	}

	// Test viewing the hand
	public void testViewHand() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan", true);
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.hand.fillHand(stack, 5);
		// Print Cards on hand
		assertEquals("[KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE]", myPlayer.viewHand());
	}
	
	// Test to get statuses methods
	public void getPlayerStatuses() {
		// Creating variables for the test
		Player testPlayer = new Player("Jan", true);
		Boolean target = false;
		// assert the methods
		assertEquals(target, testPlayer.getBulliedStatus());
		assertEquals(target, testPlayer.getHasWind());
		assertEquals(target, testPlayer.getOnBikeStatus());

	}	
	
	// Test to get the player progress
	public void testPlayerProgress() {
	    // Creating variables for the test
		Hand myHand = new Hand();
		Player myPlayer = new Player("Jan", true);

	    // Add Kilometer cards to played cards. Added two SIX to see that duplicates also work
	    Card card = new KilometerCard("FIVE");
	    Card card1 = new KilometerCard("SIX");
	
	    myPlayer.playerProgress(card);
	    myPlayer.playerProgress(card1);

	    // Calculate player progress
	    int totalKilometers = myPlayer.getKmProgress();

	    // Test total kilometers
	    assertEquals(5 + 6, totalKilometers);
	}
	
	// Test the setBulliedType and getBulliedType
	public void testSetBulliedType() {
		Player myPlayer = new Player("Jan", true);
		myPlayer.setBulliedType("TAVERN");
		String bulliedTest = "TAVERN";
		
		assertEquals(myPlayer.getBulliedType(), bulliedTest);

	}
	
	// Test getStatuses method
	public void testGetStatuses() {
		// Create a player
		Player testPlayer = new Player("Jan", true);
		
		// Change their statuses
		testPlayer.setHasWind(true);
		testPlayer.setOnBikeStatus(true);
		
		// Define the target
		String [] target = {"true", "false", "true", null};
		
		String [] test = testPlayer.getStatuses();

		assertTrue(Arrays.equals(target, test));
	}

}
