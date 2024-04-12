package logic;

public class BullyCard extends Card {

	// Constructor
	public BullyCard(String value) {
		super("BULLY", value);

		// Assign possible Bully values
		this.pos_values = new String[] { "TAVERN", "CROSSWIND", "FLAT_TIRE", "CRISS_CROSS" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 2, 4, 3, 3 };
	}

	// getRequirements method
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
			// GetOnStatus
			// BulliedStatus
			// hasWindStatus
			// Maximum number of the same cards played 
			// Bullied type 
		// None of the statuses must be active to play a bully card
		String[] requirements = {"-1", "-1", "-1", "-1", "-1"};
		return requirements;
	}

	// Implementing game logic by playing the card
	public void playCard(Player bulliedPlayer, Stack discard) {
		// Updating bullied status and onbike status
		bulliedPlayer.setBulliedStatus(true);
		bulliedPlayer.setOnBikeStatus(false);
		
		// Updating bullied type of the player
		bulliedPlayer.setBulliedType(this.getValue());

		// add card to the discard pile
		discard.addDiscardedCard(this);
	}
}
