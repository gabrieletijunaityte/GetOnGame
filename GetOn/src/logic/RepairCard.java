package logic;

public class RepairCard extends Card {

	// Constructor
	public RepairCard(String value) {
		super("REPAIR", value);

		// Assign possible repair values
		this.pos_values = new String[] { "BIKE_REPAIR", "BARRIER_OPEN" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 8, 8 };
	}

	// Create isPlayable method
	public boolean isPlayable(Player currentPlayer) {
		if (this.getValue() == "BIKE_REPAIR" && currentPlayer.getBulliedType() == "FLAT_TIRE") {
			return true;
		} else if (this.getValue() == "BARRIER_OPEN" && currentPlayer.getBulliedType() == "CRISS_CROSS") {
			return true;
		} else {
			return false;

		}
	}
}
