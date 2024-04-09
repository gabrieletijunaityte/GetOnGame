package logic;

public class BullyCard extends Card {

	// Constructor
	public BullyCard(String value) {
		super("BULLY", value);

		// Assign possible Bully values
		this.pos_values = new String[] {"TAVERN", "CROSSWIND", "FLAT_TIRE", "CRISS_CROSS"};
		validateValue(value);
		
		// Assign amount per card
		this.amount = new int [] {2, 4, 3, 3};
	}

	// IsPlayable method
	public boolean isPlayable() {
		return true;
	}
	
	public void playCard(Player bulliedPlayer) {
		// Adding bully card to the bullied person
		bulliedPlayer.getPlayedCards().addCard(this);
		
		// Updating bullied status
		bulliedPlayer.setBulliedStatus(true);
		
		// Updating bullied type of the player
//		bulliedPlayer.setBulliedType(this.getValue());
	}
	
}
