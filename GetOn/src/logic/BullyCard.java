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
}
