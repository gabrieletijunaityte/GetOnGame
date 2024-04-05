package test;

import junit.framework.TestCase;
import logic.Card;
import logic.PlayedCards;
import logic.Type;
import logic.Value;

public class PlayedCardsTest extends TestCase {
	// Test playedCard creation
	public void testCreationOfPlayedCards() {
		
		Card card = new Card(Type.getType(0), Value.getValue(0));
				
		PlayedCards playedCards = new PlayedCards(card);
		assertNotNull(playedCards);
	}
	
}
