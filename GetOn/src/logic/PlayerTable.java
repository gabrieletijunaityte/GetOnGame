package logic;

import java.util.ArrayList;

/**
 * This class handles operations related to the played card list. The purpose of
 * this class is to keep track of the cards that have been played during the
 * game.
 */
public class PlayerTable {
	private ArrayList<Card> playedCards;

	/**
	 * This method initializes an empty list of played cards to which new cards are added as
	 * they are played.
	 */
	public PlayerTable() {
		playedCards = new ArrayList<>();
	}

	/**
	 * This method iterates over the the list of played cards and counts the times a
	 * with the same name appears in this list.
	 * 
	 * @param card The card to be counted in the played cards.
	 * @return The count of how many times this specific card has been played.
	 */
	public int countCards(Card card) {
		// initiate count
		int i = 0;
		
		// iterate over the played cards
		for (Card playedCard : this.getPlayedCards()) {

			// check how many of the given specific cards are in the played pile
			if (card.getCardName().equals(playedCard.getCardName())) {
				i++;
			}
		}
		return i;
	}

	/**
	 * This method adds a new card to the played card list.
	 * 
	 * @param card The card to be added to the played cards list.
	 */
	public void addCard(Card card) {
		// Add card to table
		this.playedCards.add(card);
	}

	/**
	 * This method returns the current list of played cards.
	 * 
	 * @return List of played cards.
	 */
	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
	}
}