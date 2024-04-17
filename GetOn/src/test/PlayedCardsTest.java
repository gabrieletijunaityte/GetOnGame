package test;

import junit.framework.TestCase;
import logic.Card;
import logic.PlayerTable;
import logic.KilometerCard;

public class PlayedCardsTest extends TestCase {

	// Test playedCard creation
	public void testCreationOfPlayedCards() {
		// Create a fake card
		KilometerCard card = new KilometerCard("FIVE");
		
		// creating played card pile by playing a first card
		PlayerTable playerTable = new PlayerTable();
		
		// Assert if playCards instance was created
		assertNotNull(playerTable);
	}
	
	// Test addCard method
	public void testAddCardToPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard("FIVE");
		
		// Create the played cards
		PlayerTable playerTable = new PlayerTable();
		// Add card
		playerTable.addCard(card);
		
		assertEquals(1, playerTable.getPlayedCards().size());
	}
	
	// Test countCards method
	public void testCountPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard("FIVE");
		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayerTable playerTable = new PlayerTable();
		playerTable.addCard(card);
		playerTable.addCard(card1);
		
		assertEquals(1, playerTable.countCards(card));		
	}
	
	// Test getPlayedCards method
	public void testGetPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard("FIVE");
		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayerTable playerTable = new PlayerTable();
		playerTable.addCard(card);
		playerTable.addCard(card1);
		
		// Assert if returned card list is as expected
		assertEquals("[KILOMETER_FIVE, KILOMETER_SIX]", playerTable.getPlayedCards().toString());		
		
	}
	
	// Test playedCard creation thats empty
	public void testCreationEmptyPlayedCards() {
		// creating played card pile by playing a first card
		PlayerTable playerTable = new PlayerTable();
		
		// Assert if playCards instance was created
		assertNotNull(playerTable);
		}

}
