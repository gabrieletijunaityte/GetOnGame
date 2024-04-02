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
			stack.remove(stack.get(stack.size()-1));
		}
		return hand;
	}


	public String viewHand() {
		ArrayList<String> handCards = new ArrayList<>();
		for (Card card : hand) {
			handCards.add(card.getCardName()); 
		}
		String handCardsString = handCards.toString();
		System.out.println(handCardsString); 
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
	


	
	// Dummy Class for Player

}
