package logic;


import java.util.ArrayList;

import junit.framework.TestCase;

public class DrawCardPassTurn extends TestCase {
	
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Card> stack = new ArrayList<>();
	
	
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
}
