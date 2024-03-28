package logic;
import java.util.ArrayList;


public class Player {
	
	private ArrayList<Card> hand = new ArrayList<>();
	private Boolean isTurn;
	private String name;
	
	public Player(String name, Boolean isTurn) {
		this.name = name;
		
		this.isTurn = true;
	}
	

	public void drawCard(ArrayList<Card> stack) {
		// TODO Auto-generated method stub
		
		System.out.print(stack.get(stack.size()-1).getCardName());
		
//		System.out.print(stack[stack.length-1].getCardName());
		hand.add(stack.get(stack.size()-1));
		System.out.print(hand.get(hand.size()-1).getCardName());
		
		stack.remove(stack.get(stack.size()-1));
		
		System.out.print(stack.get(stack.size()-1).getCardName());
	}

	public String getName() {
		return name;
	}
	
	public void changeTurn() {
		
		if (isTurn) {
			this.isTurn = false;
		}
		else {
			this.isTurn = true;
		}
	}


	public ArrayList<Card> createHand(ArrayList<Card> stack) {
		// Create a dummy hand
		// Get five cards
		for (int i = 0; i < 5; i++){
			hand.add(stack.get(stack.size()-1));
		}
		return hand;
	}
	


	
	// Dummy Class for Player

}
