package test;

import java.util.ArrayList;

import junit.framework.TestCase;
import logic.Card;
import logic.KilometerCard;
import logic.PlayedCards;
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
		myPlayer.drawCard(stack, 5);

		// Test if 5 cards were drawn
		assertEquals(5, myPlayer.getHand().size());

	}

	// Test the draw card method
	public void testDrawCard() {		
		// Creating variables for the test
		Player myPlayer = new Player("Jan", true);
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.drawCard(stack, 5);

		// make player draw a card from the stack
		myPlayer.drawCard(stack);

		// Test if now player has 6 cards
		assertEquals(6, myPlayer.getHand().size());

		// Test if stack now has 93 card
		assertEquals(93, stack.getStackSize());

	}

	public void testPassTrun() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan", true);
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Draw a card and change turn (implemented inside drawCard)
		myPlayer.drawCard(stack);
		boolean test = myPlayer.getTurn();
		
		// Assert that the turn was passed
		assertEquals(false, test);
	}

	public void testViewHand() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan", true);
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.drawCard(stack, 5);

		// Print Cards on hand
		assertEquals("[KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE]", myPlayer.viewHand());
	}

	public void testAddDiscardPile() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan", true);
		Stack stack = new Stack();
		Stack discardPile = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myPlayer.drawCard(stack, 5);

		// Discard a card, parameter indicates the index of the card to be removed. this
		// is a dummy parameter.
		myPlayer.discardCard(3, discardPile);

		// test if the card is added to the discardPile
		assertEquals("KILOMETER_FIVE", discardPile.get(discardPile.getStackSize() - 1).getCardName());
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
	    Player myPlayer = new Player("Jan", true);
	    PlayedCards playedCards = new PlayedCards();

	    // Add Kilometer cards to played cards. Added two SIX to see that duplicates also work
	    playedCards.addCard(new KilometerCard("FIVE"));
	    playedCards.addCard(new KilometerCard("SIX"));
	    playedCards.addCard(new KilometerCard("SIX"));
	    playedCards.addCard(new KilometerCard("EIGHT"));
	    playedCards.addCard(new KilometerCard("TEN"));

	    // Calculate player progress
	    int totalKilometers = myPlayer.playerProgress(playedCards);

	    // Test total kilometers
	    assertEquals(5 + 6 + 6 + 8 + 10, totalKilometers);
	}

}
