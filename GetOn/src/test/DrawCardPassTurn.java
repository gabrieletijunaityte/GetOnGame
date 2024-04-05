package test;

import java.util.ArrayList;
//import java.util.Arrays;

import junit.framework.TestCase;
import logic.Card;
import logic.Type;
import logic.Value;
import logic.Player;

public class DrawCardPassTurn extends TestCase {
	
//	private ArrayList<Player> players = new ArrayList<>();
	
	public void testPlayerCreation() {
		
		// Create a player
		Player testPlayer = new Player("Jan", true);
		
		// assert that the object was created
		assertNotNull(testPlayer);
	}

	// Attributes for test
	private Player myPlayer = new Player("Jan", true);
	
	private ArrayList<Card> stack = new ArrayList<>();
	private ArrayList<Card> discardPile = new ArrayList<>();
	
	
	public void testCreateHand() {
		// Create 5 cards to test the set up
		stack.add(new Card(Type.getType(0), Value.getValue(0)));
		stack.add(new Card(Type.getType(1), Value.getValue(1)));
		stack.add(new Card(Type.getType(2), Value.getValue(0)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(1), Value.getValue(0)));

		// Create a hand
		myPlayer.drawCard(stack, 5);
		
		// Test if 5 cards were drawn
		assertEquals(5, myPlayer.getHand().size());

	}

	public void testDrawCard() {	
		// Create 5 cards to test the set up
		stack.add(new Card(Type.getType(0), Value.getValue(0)));
		stack.add(new Card(Type.getType(1), Value.getValue(1)));
		stack.add(new Card(Type.getType(2), Value.getValue(0)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(1), Value.getValue(0)));

		// Create a hand
		myPlayer.drawCard(stack, 5);

		
		// make player draw a card from the stack
		myPlayer.drawCard(stack);
		
		// Test if now player has 6 cards
		assertEquals(6, myPlayer.getHand().size());
		
		// Test if stack is now empty
		assertEquals(0, stack.size());
		
	}
	
	public void testPassTrun() {

		// Create 5 cards to test the set up
		stack.add(new Card(Type.getType(0), Value.getValue(0)));
		stack.add(new Card(Type.getType(1), Value.getValue(1)));
		stack.add(new Card(Type.getType(2), Value.getValue(0)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(1), Value.getValue(0)));
	
		
		// Draw a card and change turn (implemented inside drawcard)
		myPlayer.drawCard(stack);
		boolean test1 = myPlayer.getTurn();
		
		assertEquals(false, test1);		
	}
	

	public void testViewHand() {
		Player myPlayer = new Player("Jan", true);
		ArrayList<Card> stack = new ArrayList<>();
		// Create 5 cards to test the set up
		stack.add(new Card(Type.getType(0), Value.getValue(0)));
		stack.add(new Card(Type.getType(1), Value.getValue(1)));
		stack.add(new Card(Type.getType(2), Value.getValue(0)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(1), Value.getValue(0)));
				
		// Create a hand
		myPlayer.drawCard(stack, 5);
		
		//Print Cards on hand
		assertEquals("[bully_five, kilometer_six, kilometer_six, defense_five, bully_six]", myPlayer.viewHand());
	}
	
	public void testAddDiscardPile() {
		
		// Create 5 cards to test the set up
		stack.add(new Card(Type.getType(0), Value.getValue(0)));
		stack.add(new Card(Type.getType(1), Value.getValue(1)));
		stack.add(new Card(Type.getType(2), Value.getValue(0)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(1), Value.getValue(0)));
				
		// Create a hand
		myPlayer.drawCard(stack, 5);
		
		// Discard a card, parameter indicates the index of the card to be removed. this is a dummy parameter.
		myPlayer.discardCard(3, discardPile);
		
		// test if the card is added to the discardPile
		assertEquals("defense_five", discardPile.get(discardPile.size()-1).getCardName());
		
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
			
}
