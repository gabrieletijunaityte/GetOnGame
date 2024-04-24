package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;
import logic.Card;
import logic.KilometerCard;
import logic.PlayerTable;
import logic.Player;
import logic.Stack;
import logic.StatusCard;
import utilities.Constant;

public class PlayerTest extends TestCase {

	// Test Player creation
	public void testPlayerCreation() {
		// Create a player
		Player testPlayer = new Player("Jan");

		// assert that the object was created
		assertNotNull(testPlayer);
	}

	// Test change name
	public void testChangeName() {
		// Create a player
		Player testPlayer = new Player("Jan");
		testPlayer.changeName("Gabi");
		// assert that the object was created
		String target = "Gabi";
		assertEquals(target, testPlayer.getName());
	}

	// Test getName
	public void testGetName() {
		Player testPlayer = new Player("Jan");
		assertEquals("Jan", testPlayer.getName());
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
		
		String subTarget = Constant.KILOMETER + "_" + Constant.FIVE;
		String target = Arrays.toString(new String[] {subTarget, subTarget});

		// Test if 5 cards were drawn
		assertEquals(target, myPlayer.getHand().toString());

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
		myPlayer.drawCard(stack.drawTopCard());
		
		String subTarget = Constant.KILOMETER + "_" + Constant.FIVE;
		String target = Arrays.toString(new String[] {subTarget, subTarget});
		
		
		// Print Cards on hand
		assertEquals(target, myPlayer.viewHand());
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

	// Test to set the bullied status
	public void testSetBulliedStatus() {
		Player testPlayer = new Player("Jan");
		testPlayer.setBulliedStatus(true);
		Boolean target = true;
		assertEquals(target, testPlayer.getBulliedStatus());
	}

	// Test to get the player progress
	public void testPlayerProgress() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");

		// Add Kilometer cards to played cards. Added two SIX to see that duplicates
		// also work
		Card card = new KilometerCard(Constant.FIVE);
		Card card1 = new KilometerCard(Constant.SIX);

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
		myPlayer.setBulliedType(Constant.TAVERN);
		String bulliedTest = Constant.TAVERN;

		assertEquals(myPlayer.getBulliedType(), bulliedTest);

	}

	// Test the getWindStatus method
	public void testGetWindStatus() {
		Player myPlayer = new Player("Jan");
		myPlayer.setHasWind(true);
		assertTrue(myPlayer.getWindStatus());
	}

	// Test getStatuses method
	public void testGetStatuses() {
		// Create a player
		Player testPlayer = new Player("Jan");

		// Change their statuses
		testPlayer.setHasWind(true);
		testPlayer.setOnBikeStatus(true);

		// Define the target
		String[] target = { Constant.TRUE, Constant.FALSE, Constant.TRUE, null };

		String[] test = testPlayer.getStatuses();

		assertTrue(Arrays.equals(target, test));
	}

	// Broken Tests
	// Test getConsequences Implementation for Get On
	public void testSetConsequencesCaseA() {

		Card testCard = new StatusCard(Constant.GET_ON);

		String[] consequences = testCard.getConsequences();

		Player testPlayer = new Player("Jan");

		testPlayer.setConsequences(consequences);

		// Define the target
		String[] target = { Constant.TRUE, Constant.FALSE, Constant.FALSE, null };

		String[] test = testPlayer.getStatuses();

		assertTrue(Arrays.equals(target, test));

	}

	// Test getConsequences Implementation for Bully
	public void testSetConsequencesCaseB() {

		Card testCard = new BullyCard(Constant.TAVERN);

		String[] consequences = testCard.getConsequences();

		Player testPlayer = new Player("Jan");

		testPlayer.setOnBikeStatus(true);
		testPlayer.setConsequences(consequences);

		// Define the target
		String[] target = { Constant.FALSE, Constant.FALSE, Constant.FALSE, null };

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
		Card cardToRemove = new BullyCard(Constant.TAVERN);

		myPlayer.drawCard(cardToRemove);

		// Removing the card
		myPlayer.discardCard(cardToRemove);

		// Test if the only card in the hand is a kilometer five card
		assertEquals("[" + Constant.KILOMETER + "_" + Constant.FIVE + "]", myPlayer.getHand().toString());
	}

	// Test add card to player table method and test getPlayedCards
	public void testAddToTable() {
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();
		stack.initializeStack();
		Card card = stack.drawTopCard();

		myPlayer.addToTable(card);
		PlayerTable playerTable = myPlayer.getPlayedCards();

		String target = "[" + Constant.KILOMETER + "_" + Constant.FIVE + "]";
		String test = playerTable.getPlayedCards().toString();

		assertEquals(target, test);
	}

	// Test to set the Kilometer progress
	public void testSetKmProgress() {
		Player myPlayer = new Player("Test player");
		assertEquals(0, myPlayer.getKmProgress());

		myPlayer.setKmProgress(50);
		assertEquals(50, myPlayer.getKmProgress());

	}
}
