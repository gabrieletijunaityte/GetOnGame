package test;

import junit.framework.TestCase;
import logic.Card;
import logic.PlayedCards;
import logic.Type;
import logic.Value;
import logic.KilometerCard;

public class PlayedCardsTest extends TestCase {

	// Test playedCard creation
	public void testCreationOfPlayedCards() {
		// Create a fake card
		Card card = new Card(Type.getType(0), Value.getValue(0));
		// Replace with this after merging
//		KilometerCard card = new KilometerCard("FIVE");
		
		// creating played card pile by playing a first card
		PlayedCards playedCards = new PlayedCards(card);
		
		// Assert if playCards instance was created
		assertNotNull(playedCards);
	}
	
	// Test addCard method
	public void testAddCardToPlayedCards() {
		// Create fake cards
		Card card = new Card(Type.getType(0), Value.getValue(0));
		Card card1 = new Card(Type.getType(1), Value.getValue(0));
		// Replace with this after merging
//		KilometerCard card = new KilometerCard("FIVE");
//		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayedCards playedCards = new PlayedCards(card);
		// Add card
		playedCards.addCard(card1);
		
		assertEquals(2, playedCards.getPlayedCards().size());
	}
	

	// Test countCards method
	public void testCountPlayedCards() {
		// Create fake cards
		Card card = new Card(Type.getType(0), Value.getValue(0));
		Card card1 = new Card(Type.getType(0), Value.getValue(0));
		
		// Replace with this after merging
//		KilometerCard card = new KilometerCard("FIVE");
//		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayedCards playedCards = new PlayedCards(card);
		playedCards.addCard(card1);
		
		assertEquals(2, playedCards.countCards(card));		
	}
	
	// Test getPlayedCards method
	public void testGetPlayedCards() {
		// Create fake cards
		Card card = new Card(Type.getType(0), Value.getValue(0));
		Card card1 = new Card(Type.getType(0), Value.getValue(0));
		
		// Replace with this after merging
//		KilometerCard card = new KilometerCard("FIVE");
//		KilometerCard card1 = new KilometerCard("SIX");
		
		// Create the played cards
		PlayedCards playedCards = new PlayedCards(card);
		playedCards.addCard(card1);
		
		// Assert if returned card list is as expected
		assertEquals("[kilometer_five, kilometer_five]", playedCards.getPlayedCards().toString());		
		// to be replaced after merge
//		assertEquals("[KILOMETER_FIVE, KILOMETER_SIX]", playedCards.getPlayedCards().toString());		
		
	}

}
