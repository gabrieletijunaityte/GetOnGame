package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.PlayerTable;
import utilities.Constant;
import logic.KilometerCard;

public class PlayerTableTest extends TestCase {

	// Test playedCard creation
	public void testCreationOfPlayedCards() {	
		// creating played card pile by playing a first card
		PlayerTable playerTable = new PlayerTable();
		
		// Assert if playCards instance was created
		assertNotNull(playerTable);
	}
	
	// Test addCard method
	public void testAddCardToPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard(Constant.FIVE);
		
		// Create the played cards
		PlayerTable playerTable = new PlayerTable();
		// Add card
		playerTable.addCard(card);
		
		assertEquals(1, playerTable.getPlayedCards().size());
	}
	
	// Test countCards method
	public void testCountPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard(Constant.FIVE);
		KilometerCard card1 = new KilometerCard(Constant.SIX);
		
		// Create the played cards
		PlayerTable playerTable = new PlayerTable();
		playerTable.addCard(card);
		playerTable.addCard(card1);
		
		assertEquals(1, playerTable.countCards(card));		
	}
	
	// Test getPlayedCards method
	public void testGetPlayedCards() {
		// Create fake cards
		KilometerCard card = new KilometerCard(Constant.FIVE);
		KilometerCard card1 = new KilometerCard(Constant.SIX);
		
		// Create the played cards
		PlayerTable playerTable = new PlayerTable();
		playerTable.addCard(card);
		playerTable.addCard(card1);
		
		String target = Arrays.toString(new String[] {Constant.KILOMETER + "_" + Constant.FIVE, Constant.KILOMETER + "_" + Constant.SIX});
		
		// Assert if returned card list is as expected
		assertEquals(target, playerTable.getPlayedCards().toString());		
		
	}
	
	// Test playedCard creation thats empty
	public void testCreationEmptyPlayedCards() {
		// creating played card pile by playing a first card
		PlayerTable playerTable = new PlayerTable();
		
		// Assert if playCards instance was created
		assertNotNull(playerTable);
		}

}