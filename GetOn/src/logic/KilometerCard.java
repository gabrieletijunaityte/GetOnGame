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
		if (this.getValue() == "FIVE" && currentPlayer.getPlayedCards().countCards(this) < 8) {
			return true;
		}
		else if (this.getValue() == "SIX" && currentPlayer.getPlayedCards().countCards(this) < 4) {
			return true;
		}
		else if ((this.getValue() == "EIGHT" || this.getValue()  == "TEN") && currentPlayer.getPlayedCards().countCards(this) < 2 && currentPlayer.getHasWind()) {
			return true;
		}
		else {
			return false;
		}
	}

}
