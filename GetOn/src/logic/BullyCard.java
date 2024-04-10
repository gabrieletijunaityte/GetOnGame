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

	// IsPlayable method
	public boolean isPlayable() {
		return true;
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
