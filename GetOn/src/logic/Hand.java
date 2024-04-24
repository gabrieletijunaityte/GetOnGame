package logic;

import java.util.ArrayList;

/**
 * Hand class handles the creation of the player Hand, add and discard cards to
 * the Hand.
 */
public class Hand {
	private ArrayList<Card> hand; // hand of the player, contains an ArrayList of Card

	/**
	 * Constructor for the Hand class
	 */
	public Hand() {
		this.hand = new ArrayList<>();
	}

	/**
	 * Method to add a Card to the Player's Hand.
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		// Add a card to the hand
		hand.add(card);
	}

	/**
	 * Method to discard a card from the Player's Hand.
	 * 
	 * @param discardedCard
	 */
	public void discardCard(Card discardedCard) {
		// Remove the discarded card from the hand
		hand.remove(discardedCard);
	}

	/**
	 * Method to get the Hand of the Player.
	 * 
	 * @return The hand of the Player.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}

	/**
	 * Method to return the Index of the card selected by the Player
	 * 
	 * @param selectedCardIndex
	 * @return Index of the card from the Hand, that is selected.
	 */
	public Card get(int selectedCardIndex) {
		return this.hand.get(selectedCardIndex);
	}
}