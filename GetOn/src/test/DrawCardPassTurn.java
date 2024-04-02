package test;


import java.util.ArrayList;



import junit.framework.TestCase;
import logic.Card;
import logic.Player;

public class DrawCardPassTurn extends TestCase {
	
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Card> stack = new ArrayList<>();
	// a stack for the discarded cards
	public ArrayList<Card> discardPile = new ArrayList<>();
	
	public void testPlayerCreation() {
		
		ArrayList<Player> players = new ArrayList<>();
		assertNotNull(players);
		
	}
	
	
	public void testDrawCard() {
		

		Player player1 = new Player("Player1", true);
		
		stack.add(new Card("test1"));
		stack.add(new Card("test2"));
		player1.drawCard(stack);
		
	}
	
	
	public void testPassTrun() {
		

		players.add(new Player("abc", true));
		players.add(new Player("dfa", false));
		
		stack.add(new Card("test1"));
		stack.add(new Card("test2"));
		
		players.get(0).drawCard(stack);
		players.get(0).changeTurn();
		players.get(1).changeTurn();
		
		
	}
	
	public void testCreateHand() {
		// Create a player that holds the hand
		Player myPlayer = new Player("Jan", true);
		
		// Create 5 cards to test the set up
		stack.add(new Card("1"));
		stack.add(new Card("2"));
		stack.add(new Card("3"));
		stack.add(new Card("4"));
		stack.add(new Card("5"));
		
		// Create a hand
		ArrayList<Card> hand = myPlayer.createHand(stack);
		assertEquals(5, hand.size());

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
		ArrayList<Card> hand = myPlayer.createHand(stack);
		
		//Print Cards on hand
		myPlayer.viewHand();
		assertEquals("[5, 4, 3, 2, 1]", myPlayer.viewHand());
			}
	
	public void testAddDiscardPile() {
		// Create a player to test
		Player myPlayer = new Player("Niels", true);
		
		// Create 5 cards to test the set up
		stack.add(new Card("Card 5"));
		stack.add(new Card("Card 4"));
		stack.add(new Card("Card 3"));
		stack.add(new Card("Card 2"));
		stack.add(new Card("Card 1"));
		
		// Create a hand
		ArrayList<Card> hand = myPlayer.createHand(stack);
		
		// Discard a card, parameter indicates the index of the card to be removed. this is a dummy parameter.
		myPlayer.discardCard(3, discardPile);
		
		// test if the card is added to the discardPile
		assertEquals("Card 4", discardPile.get(discardPile.size()-1).getCardName());
		
	}
}
