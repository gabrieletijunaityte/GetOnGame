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
import logic.StatusCard;

public class PlayerTest extends TestCase {

	// Test Player creation
	public void testPlayerCreation() {
		// Create a player
		Player testPlayer = new Player("Jan");

		// assert that the object was created
		assertNotNull(testPlayer);
	}

	// Test hand creation
	public void testGetHand() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.drawCard(stack.drawTopCard());
		myPlayer.drawCard(stack.drawTopCard());

		// Test if 5 cards were drawn
		assertEquals("[KILOMETER_FIVE, KILOMETER_FIVE]", myPlayer.getHand().toString());

	}

	// Test viewing the hand
	public void testViewHand() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.drawCard(stack.drawTopCard());
		// Print Cards on hand
		assertEquals("[KILOMETER_FIVE]", myPlayer.viewHand());
	}

	// Test to get statuses methods
	public void getPlayerStatuses() {
		// Creating variables for the test
		Player testPlayer = new Player("Jan");
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
		Player myPlayer = new Player("Jan");

		// Add Kilometer cards to played cards. Added two SIX to see that duplicates
		// also work
		Card card = new KilometerCard("FIVE");
		Card card1 = new KilometerCard("SIX");

		myPlayer.playerProgress(card.getValue());
		myPlayer.playerProgress(card1.getValue());

		// Calculate player progress
		int totalKilometers = myPlayer.getKmProgress();

		// Test total kilometers
		assertEquals(5 + 6, totalKilometers);
	}

	// Test the setBulliedType and getBulliedType
	public void testSetBulliedType() {
		Player myPlayer = new Player("Jan");
		myPlayer.setBulliedType("TAVERN");
		String bulliedTest = "TAVERN";

		assertEquals(myPlayer.getBulliedType(), bulliedTest);

	}

	// Test getStatuses method
	public void testGetStatuses() {
		// Create a player
		Player testPlayer = new Player("Jan");

		// Change their statuses
		testPlayer.setHasWind(true);
		testPlayer.setOnBikeStatus(true);

		// Define the target
		String[] target = { "true", "false", "true", null };

		String[] test = testPlayer.getStatuses();

		assertTrue(Arrays.equals(target, test));
	}

	// Broken Tests
	// Test getConsequences Implementation for Get On
	public void testSetConsequencesCaseA() {

		Card testCard = new StatusCard("GET_ON");

		String[] consequences = testCard.getConsequences();

		Player testPlayer = new Player("Jan");

		testPlayer.setConsequences(consequences);

		// Define the target
		String[] target = { "true", "false", "false", null };

		String[] test = testPlayer.getStatuses();

		assertTrue(Arrays.equals(target, test));

	}

	// Test getConsequences Implementation for Bully
	public void testSetConsequencesCaseB() {

		Card testCard = new BullyCard("TAVERN");

		String[] consequences = testCard.getConsequences();

		Player testPlayer = new Player("Jan");

		testPlayer.setOnBikeStatus(true);
		testPlayer.setConsequences(consequences);

		// Define the target
		String[] target = { "false", "false", "false", null };

		String[] test = testPlayer.getStatuses();

		assertTrue(Arrays.equals(target, test));

	}

	// Test drawCard method
	public void testDrawCard() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		Card drawnCard = stack.drawTopCard();

		// Create a hand with drawn card
		myPlayer.drawCard(drawnCard);

		// Test if 5 cards were drawn
		assertEquals(drawnCard.toString(), myPlayer.getCard(0).toString());

	}

	// Test getCard method
	public void testGetCard() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		Card drawnCard = stack.drawTopCard();

		// Create a hand with drawn card
		myPlayer.drawCard(drawnCard);

		// Test if 5 cards were drawn
		assertEquals(1, myPlayer.getHand().size());
	}
	
	// Test card removal from hand
	public void testDiscardCard() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand with drawn card
		myPlayer.drawCard(stack.drawTopCard());

		// Creating card to 
		Card cardToRemove = new BullyCard("TAVERN");
		
		myPlayer.drawCard(cardToRemove);
		
		// Removing the card
		myPlayer.discardCard(cardToRemove);
		
		// Test if 5 cards were drawn
		assertEquals("[KILOMETER_FIVE]", myPlayer.getHand().toString());
	}
	
	// Test add card to player table method
	public void testAddToTable() {
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();
		stack.initializeStack();
		Card card = stack.drawTopCard();
		
		myPlayer.addToTable(card);
		PlayerTable playerTable = myPlayer.getPlayedCards();
		
		String target = "[KILOMETER_FIVE]";
		String test = playerTable.getPlayedCards().toString();
		
		assertEquals(target, test);
	}
}
