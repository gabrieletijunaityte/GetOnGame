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
}