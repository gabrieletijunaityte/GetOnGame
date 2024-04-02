package test;


import java.util.ArrayList;



import junit.framework.TestCase;
import logic.Card;
import logic.Player;

public class DrawCardPassTurn extends TestCase {
	
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Card> stack = new ArrayList<>();
	private Player myPlayer = new Player("Jan", true);
	public ArrayList<Card> discardPile = new ArrayList<>();
	
	public void testPlayerCreation() {
		
		// Create players array
		ArrayList<Player> players = new ArrayList<>();	
		
		// assert that the array was created
		assertNotNull(players);
	}
	

	public void testCreateHand() {
		// Create 5 cards to test the set up
		stack.add(new Card("1"));
		stack.add(new Card("2"));
		stack.add(new Card("3"));
		stack.add(new Card("4"));
		stack.add(new Card("5"));
		
		// Create a hand
		myPlayer.drawCard(stack, 5);
		
		assertEquals(5, myPlayer.getHand().size());

	}

	public void testDrawCard() {	
		// initiate stack
		stack.add(new Card("1"));
		stack.add(new Card("2"));
		stack.add(new Card("3"));
		stack.add(new Card("4"));
		stack.add(new Card("5"));
		stack.add(new Card("6"));
		stack.add(new Card("7"));
		
		// Create a hand
		myPlayer.drawCard(stack, 5);

		
		// make player draw a card from the stack
		myPlayer.drawCard(stack);
		
		assertEquals(6, myPlayer.getHand().size());
		
	}
	
	public void testPassTrun() {
		
		// initiate stack
		stack.add(new Card("1"));
		stack.add(new Card("2"));
		stack.add(new Card("3"));
		stack.add(new Card("4"));
		stack.add(new Card("5"));
		stack.add(new Card("6"));
		stack.add(new Card("7"));
	
		
		// Draw a card and change turn (implemented inside drawcard)
		myPlayer.drawCard(stack);
		boolean ret = myPlayer.getTurn();
		
		assertEquals(false, ret);		
	}
	

	public void testViewHand() {
		// Create a player that holds the hand
		Player myPlayer = new Player("Jan", true);
				
		// Create 5 cards to test the set up
		stack.add(new Card("1"));
		stack.add(new Card("2"));
		stack.add(new Card("3"));
		stack.add(new Card("4"));
		stack.add(new Card("5"));
				
		// Create a hand
		myPlayer.drawCard(stack, 5);
		
		//Print Cards on hand
		myPlayer.viewHand();
		assertEquals("[5, 4, 3, 2, 1]", myPlayer.viewHand());
			}
	
	public void testAddDiscardPile() {
		
		// Create 5 cards to test the set up
		stack.add(new Card("Card 5"));
		stack.add(new Card("Card 4"));
		stack.add(new Card("Card 3"));
		stack.add(new Card("Card 2"));
		stack.add(new Card("Card 1"));
		
		// Create a hand
		myPlayer.drawCard(stack, 5);
		
		// Discard a card, parameter indicates the index of the card to be removed. this is a dummy parameter.
		myPlayer.discardCard(3, discardPile);
		
		// test if the card is added to the discardPile
		assertEquals("Card 4", discardPile.get(discardPile.size()-1).getCardName());
		
	}
}
