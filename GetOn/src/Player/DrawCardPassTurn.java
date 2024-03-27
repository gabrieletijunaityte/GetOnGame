package Player;


import java.util.ArrayList;

import junit.framework.TestCase;

public class DrawCardPassTurn extends TestCase {
	
	public void testPlayerCreation() {
		
		Player player1 = new Player();
		assertNotNull(player1);
		
	}
	
	
	
	public void testDrawCard() {
		
		Player player1 = new Player();
		ArrayList<Card> stack = new ArrayList<>();
		stack.add(new Card("test1"));
		stack.add(new Card("test2"));
		player1.drawCard(stack);
		
	}

}
