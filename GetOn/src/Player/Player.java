package Player;
import java.util.ArrayList;


public class Player {
	
	private ArrayList<Card> hand = new ArrayList<>();
	

	public void drawCard(ArrayList<Card> stack) {
		// TODO Auto-generated method stub
		
		System.out.print(stack.get(stack.size()-1).getCardName());
		
//		System.out.print(stack[stack.length-1].getCardName());
		hand.add(stack.get(stack.size()-1));
		System.out.print(hand.get(hand.size()-1).getCardName());
		
		stack.remove(stack.get(stack.size()-1));
		
		System.out.print(stack.get(stack.size()-1).getCardName());
	}
	
	// Dummy Class for Player

}
