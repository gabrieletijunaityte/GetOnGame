package logic;

import java.util.ArrayList;

/**
 * Manages the collection of played cards on the player's table.
 * <p>
 * This class handles operations related to the played card list. The
 * purpose of this class is to keep track of the cards that have been
 * played during the game.
 * </p>
 */
public class PlayerTable {
	private ArrayList<Card> playedCards;

	/**
	 * Constructs a new PlayerTable with an empty list of played cards.
	 * <p>
	 * Initializes an empty list of played cards to which new cards are added as
	 * they are played.
	 * </p>
	 */
	public PlayerTable() {
		playedCards = new ArrayList<>();
	}

	/**
	 * Counts the number of times a specific card has been played.
	 * <p>
	 * This method iterates over the the list of played cards and counts the times a
	 * with the same name appears in this list.
	 * </p>
	 * @param card The card to be counted in the played cards.
	 * @return The count of how many times this specific card has been played.
	 */
	// Count how many of a specific cards have been played
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
	 * Adds a card to the list of played cards on the table.
	 * <p>
	 * This method adds a new card to the played card list.
	 * </p>
	 * @param card The card to be added to the played cards list.
	 */
	public void addCard(Card card) {
		// Add card to table
		this.playedCards.add(card);
	}

	/**
	 * Retrieves the list of cards that have been played on the table.
	 * <p>
	 * This method returns the current list of played cards.
	 * </p>
	 * @return List of played cards.
	 */
	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
	}
}