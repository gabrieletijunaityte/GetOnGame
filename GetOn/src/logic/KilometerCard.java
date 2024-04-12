package logic;

public class KilometerCard extends Card {

	// Constructor
	public KilometerCard(String value) {
		super("KILOMETER", value);

		// Assign possible km values
		this.pos_values = new String[] { "FIVE", "SIX", "EIGHT", "TEN" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 24, 12, 8, 8 };
	}

	// IsPlayable method
	public boolean isPlayable(Player currentPlayer) {
		if (currentPlayer.getOnBikeStatus()) {
			if (this.getValue() == "FIVE" && currentPlayer.getPlayedCards().countCards(this) < 8) {
				return true;
			} else if (this.getValue() == "SIX" && currentPlayer.getPlayedCards().countCards(this) < 4) {
				return true;
			} else if ((this.getValue() == "EIGHT" || this.getValue() == "TEN")
					&& currentPlayer.getPlayedCards().countCards(this) < 2 && currentPlayer.getHasWind()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	// Implementing game logic by playing the card
	public void playCard(Player currentPlayer, Stack discard) {
		if (isPlayable(currentPlayer)){
			// Add the card to the playedCards
			currentPlayer.getPlayedCards().addCard(this);
			System.out.println(currentPlayer.getPlayedCards());

			
			// Update the progress
			currentPlayer.playerProgress(this);
					}
		// If not playable, discard the card
		else {
			discard.addDiscardedCard(this);
		}
	}
	
	// getRequirements method
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
			// GetOnStatus
			// BulliedStatus
			// hasWindStatus
			// Bullied type (-1 - ignore)
			// Maximum number of the same cards played (-1 for no limit)
		String value = this.getValue();
		
		// To play 5 km: (to be on bike, not bullied and 8 cards max)
		if (value.equals("FIVE")) {
			String [] requirements = {"true", "false", "-1", "-1", "8"};
			return requirements;
		}
		// To play 6 km: (to be on bike, not bullied and 4 cards max)
		else if (value.equals("SIX")) {
			String [] requirements = {"true", "false", "-1", "-1", "4"};
			return requirements;
		}
		// To play 8 or 10 km: (to be on bike, not bullied, to have wind and 2 cards max)
		else {
			String [] requirements = {"true", "false", "true", "-1", "2"};
			return requirements;
		}
	}
}
