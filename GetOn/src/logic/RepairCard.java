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
	
	// Implementing game logic by playing the card
	public void playCard(Player targetPlayer, Stack discard) {
		// Change bulliedstatus to false
		targetPlayer.setBulliedStatus(false);
		
		// Set bullied type string back to empty
		targetPlayer.setBulliedType("");
		
		// add card to the discard pile
		discard.addDiscardedCard(this);
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
		
		// To play BIKE_REPAIR: be bullied with FLAT_TIRE
		if (value.equals("BIKE_REPAIR")) {
			String [] requirements = {"-1", "true", "-1", "FLAT_TIRE", "-1"};
			return requirements;
		}
		// To play BARRIER_OPEN: be bullied with CRISS_CROSS
		else {
			String [] requirements = {"-1", "true", "-1", "CRISS_CROSS", "-1"};
			return requirements;
		}
	}
}
