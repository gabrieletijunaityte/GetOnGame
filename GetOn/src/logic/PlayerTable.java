package logic;

import java.util.ArrayList;

public class PlayerTable {
	private ArrayList<Card> playedCards;

	
	// Return empty playedCards list
	public PlayerTable() {
		playedCards = new ArrayList<>();
	}

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

	public void addCard(Card card) {
		// Add card to table
		this.playedCards.add(card);
	}

	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
	}
}