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
		assertTrue(target.equals(testPlayer.getName()));
	}

	// Test getName
	public void testGetName() {
		Player testPlayer = new Player("Jan");
		assertTrue("Jan".equals(testPlayer.getName()));
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
		assertTrue(target.equals(myPlayer.getHand().toString()));

	}

	// Test to get OnBike status method
	public void testGetPlayerOnBikeStatuse() {
		// Creating variables for the test
		Player testPlayer = new Player("Jan");
		boolean target = false;
		// assert the method
		assertEquals(target, testPlayer.getOnBikeStatus());
	}
	
	// Test to set OnBike status method
	public void testSetPlayerOnBikeStatuse() {
		// Creating variables for the test
		Player testPlayer = new Player("Jan");
		boolean target = true;
		testPlayer.setOnBikeStatus(true);
		// assert the method
		assertEquals(target, testPlayer.getOnBikeStatus());
	}
	
	// Test to get hasWind status method
	public void testGetHasWind() {
		// Creating variables for the test
		Player testPlayer = new Player("Jan");
		boolean target = false;
		// assert the method
		assertEquals(target, testPlayer.getHasWind());
	}
	
	// Test to set hasWind status method
	public void testSetHasWind() {
		// Creating variables for the test
		Player testPlayer = new Player("Jan");
		boolean target = true;
		testPlayer.setHasWind(target);
		
		// assert the method
		assertEquals(target, testPlayer.getHasWind());
	}
	
	// Test to get the bullied status
	public void testGetBulliedStatus() {
		Player testPlayer = new Player("Jan");
		boolean target = false;
		
		assertEquals(target, testPlayer.getBulliedStatus());
	}

	// Test to set the bullied status
	public void testSetBulliedStatus() {
		Player testPlayer = new Player("Jan");
		testPlayer.setBulliedStatus(true);
		boolean target = true;
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

	// Test the getBulliedType and setBulliedType and getBulliedType
	public void testSetBulliedType() {
		Player myPlayer = new Player("Jan");
		myPlayer.setBulliedType(Constant.TAVERN);
		String bulliedTestTarget = Constant.TAVERN;

		assertTrue(bulliedTestTarget.equals(myPlayer.getBulliedType()));
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
		assertTrue(drawnCard.toString().equals(myPlayer.getCard(0).toString()));
	}

	// Test get card method
	public void testGetCard() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		Card drawnCard = stack.drawTopCard();

		// Create a hand with drawn card
		myPlayer.drawCard(drawnCard);
		Card test = myPlayer.getCard(0);

		// Test if 5 cards were drawn
		assertEquals(drawnCard, test);
	}

	// Test card removal from hand
	public void testDiscardCard() {
		// Creating variables for the test
		Player myPlayer = new Player("Jan");
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand with drawn card
		Card target = stack.drawTopCard();
		myPlayer.drawCard(target);

		// Creating card to
		Card cardToRemove = new BullyCard(Constant.TAVERN);

		myPlayer.drawCard(cardToRemove);

		// Removing the card
		myPlayer.discardCard(cardToRemove);

		// Test if the only card in the hand is a kilometer five card
		assertTrue(("[" + target+ "]").equals(myPlayer.getHand().toString()));
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

		assertTrue(target.equals(test));
	}

	// Test to set the Kilometer progress
	public void testSetKmProgress() {
		Player myPlayer = new Player("Test player");
		assertEquals(0, myPlayer.getKmProgress());

		myPlayer.setKmProgress(50);
		assertEquals(50, myPlayer.getKmProgress());

	}
}
