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


	public void discardCard(int i, ArrayList<Card> discardPile) {
		// Add the discarded card to the discardPile and remove the card from the hand
		// Check if the index is possible, if not, throw exception
		if (i<0 || i >= 5) {
			throw new IllegalArgumentException("The index must be cannot be lower than 0 and higher than 4");
		} else {
			// Set discarded card to the parameter index of the hand.
			Card discardedCard = hand.get(i);
			// Add the discarded card to the discardPile
			discardPile.add(discardedCard);
			// Remove the card from the hand
			hand.remove(i);
			// Show which card is removed
			System.out.println(discardedCard.getCardName() + ": has been discarded from your hand");
		}
		// Show the hand after the removal
		System.out.println("Current hand: " + viewHand());
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}


}
