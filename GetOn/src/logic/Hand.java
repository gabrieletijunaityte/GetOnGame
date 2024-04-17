package logic;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;

	public Hand() {
		this.hand = new ArrayList<>();
	}

	public void addCard(Card card) {
		// Add a card to the hand
		hand.add(card);
	}

	public void discardCard(Card discardedCard) {
		// Remove the discarded card from the hand
		hand.remove(discardedCard);
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public Card get(int selectedCardIndex) {
		return this.hand.get(selectedCardIndex);
	}

}