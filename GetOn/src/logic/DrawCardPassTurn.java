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

}
