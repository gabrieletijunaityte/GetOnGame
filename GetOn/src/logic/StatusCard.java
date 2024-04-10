package logic;

public class StatusCard extends Card {

	// Constructor
	public StatusCard(String value) {
		super("STATUS", value);

		// Assign possible status values
		this.pos_values = new String[] { "GET_ON", "TAIL_WIND" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 14, 5 };
	}

	// IsPlayable method
	public boolean isPlayable(Player currentPlayer) {
		if (this.getValue() == "TAIL_WIND") {
			return true;
		} else if (!currentPlayer.getOnBikeStatus()) {
			if (!currentPlayer.getBulliedStatus()) {
				return true;
			}
		}
		return false;
	}

	// Implementing game logic by playing the card
	public void playCard(Player currentPlayer, Stack discard) {
		if (isPlayable(currentPlayer)) {
			// Add the card to the playedCards
			if (this.getValue() == "TAIL_WIND") {	
				// Change
				currentPlayer.setHasWind(true);
				
				// Put the "TAIL_WIND" card into discard pile
				discard.addDiscardedCard(this);
			} else {
				// Change the on bike status
				currentPlayer.setOnBikeStatus(true);
				
				// Put the "GET_ON" card into discard pile
				discard.addDiscardedCard(this);
				
			}
		}
		// If not playable, discard the card
		else {
			discard.addDiscardedCard(this);
		}
	}
}