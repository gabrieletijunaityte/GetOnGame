package logic;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;

	public Hand() {
		this.hand = new ArrayList<>();
	}
	
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public void addCard(Card card) {
		// Add a card to the hand
		hand.add(card);
	}

	public void drawCard(Stack stack) {
		
		// Add a card to the hand
		Card topCard = stack.drawTopCard();
		addCard(topCard);
	}

	public void fillHand(Stack stack, int amount) {
		// Create a dummy hand
		// Get five cards
		ArrayList<Card> temp_hand = new ArrayList<>();
	
		for (int i = 0; i < amount; i++) {
			temp_hand.add(stack.drawTopCard());
		}
		setHand(temp_hand);
	}

	public void discardedCard(Card discardedCard, Stack discardPile) {
		// Add the discarded card to the discardPile and remove the card from the hand
	
			// Add the discarded card to the discardPile
			discardPile.addDiscardedCard(discardedCard);
			// Remove the card from the hand
			hand.remove(discardedCard);
	
		}

		public ArrayList<Card> getHand() {
			return hand;
		}
}