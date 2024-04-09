package test;

import junit.framework.TestCase;
import logic.Card;
import logic.PlayedCards;
import logic.KilometerCard;

public class PlayedCardsTest extends TestCase {

	// Test playedCard creation
	public void testCreationOfPlayedCards() {
		// Create a fake card
		KilometerCard card = new KilometerCard("FIVE");
		
		// creating played card pile by playing a first card
		PlayedCards playedCards = new PlayedCards();
		
		// Assert if playCards instance was created
		assertNotNull(playedCards);
	}
	
	// Test addCard method
	public void testAddCardToPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard("FIVE");
		
		// Create the played cards
		PlayedCards playedCards = new PlayedCards();
		// Add card
		playedCards.addCard(card);
		
		assertEquals(1, playedCards.getPlayedCards().size());
	}
	
	// Test countCards method
	public void testCountPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard("FIVE");
		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayedCards playedCards = new PlayedCards();
		playedCards.addCard(card);
		playedCards.addCard(card1);
		
		assertEquals(2, playedCards.countCards(card));		
	}
	
	// Test getPlayedCards method
	public void testGetPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard("FIVE");
		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayedCards playedCards = new PlayedCards();
		playedCards.addCard(card);
		playedCards.addCard(card1);
		
		// Assert if returned card list is as expected
		assertEquals("[KILOMETER_FIVE, KILOMETER_SIX]", playedCards.getPlayedCards().toString());		
		
	}
	
	// Test playedCard creation thats empty
	public void testCreationEmptyPlayedCards() {
		// creating played card pile by playing a first card
		PlayedCards playedCards = new PlayedCards();
		
		// Assert if playCards instance was created
		assertNotNull(playedCards);
		}

}
