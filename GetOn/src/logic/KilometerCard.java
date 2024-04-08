package logic;

public class KilometerCard extends Card {

	// Constructor
	public KilometerCard(String value) {
		super("KILOMETER", value);

		// Assign possible km values
		this.pos_values = new String[]{"FIVE","SIX","EIGHT","TEN"};
		validateValue(value);
	
		// Assign amount per card
		this.amount = new int [] {24, 12, 8, 8};
	}
	
}
