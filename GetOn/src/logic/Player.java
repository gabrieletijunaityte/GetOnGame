package logic;
import java.util.ArrayList;


public class Player {
	
	private ArrayList<Card> hand;
	private Boolean isTurn;
	private String name;
	
	public Player(String name, Boolean isTurn) {
		this.name = name;
		this.isTurn = true;
		this.hand = new ArrayList<>();
	}
	

	public void drawCard(ArrayList<Card> stack) {
	
		// Add a card to the hand	
		this.hand.add(stack.get(stack.size()-1));
		
		
		// Remove the added card from the stack
		stack.remove(stack.get(stack.size()-1));
		
		// change turn after drawing a card
		changeTurn();
	}

	public String getName() {
		return name;
	}
	
	public Boolean getTurn() {
		return this.isTurn;
	}
	
	private void changeTurn() {
		if (isTurn) {
			this.isTurn = false;
		}
		else {
			this.isTurn = true;
		}
	}


	public void drawCard(ArrayList<Card> stack, int amount) {
		// Create a dummy hand
		// Get five cards
		ArrayList<Card> temp_hand = new ArrayList<>();
		
		for (int i = 0; i < amount; i++){
			temp_hand.add(stack.get(stack.size()-1));
			stack.remove(stack.get(stack.size()-1));
		}
		this.hand = temp_hand;
	}


	public String viewHand() {
		ArrayList<String> handCards = new ArrayList<>();
		for (Card card : this.hand) {
			handCards.add(card.getCardName()); 
		}
		String handCardsString = handCards.toString();
//		System.out.println(handCardsString); 
		return handCardsString; 
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}


}
