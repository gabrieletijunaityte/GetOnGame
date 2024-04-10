package test;

import java.util.ArrayList;

import junit.framework.TestCase;
import logic.BullyCard;
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
	

	// Test bullying process
	public void testSelectCard() {
		// creating dummy players
		Player bullyPlayer = new Player("Jan", true);
		Player bulliedPlayer = new Player("Gabby", false);
		
		// Dummy stack
		Stack stack = new Stack();
		stack.initializeStack();
		
		// Dummy discard stack
		Stack discard = new Stack();
		
		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");
		
		// Giving the bully card to Jan
		bullyPlayer.addCard(bullyCard);
		
		// Test Jan playing bully to Gabby
		bullyPlayer.selectCard(bullyCard, bulliedPlayer, stack, discard);
		
		// Testing if Gabby's bully status has changed
		boolean target = true;
		boolean test = bulliedPlayer.getBulliedStatus();
		
		assertEquals(target, test);
		
		// Testing if Gabby has now a card on the table
		String test1 = bulliedPlayer.getPlayedCards().toString();
		assertNotNull(test1);
		
		// Check if Jan passed turn
		boolean target1 = false;
		boolean test2 = bullyPlayer.getTurn();
		
		assertEquals(target1, test2);
	}
	
	// Test the setBulliedType and getBulliedType
	public void testSetBulliedType() {
	    Player myPlayer = new Player("Jan", true);
		myPlayer.setBulliedType("TAVERN");
		String bulliedTest = "TAVERN";
		
		assertEquals(myPlayer.getBulliedType(), bulliedTest);

	}

}
