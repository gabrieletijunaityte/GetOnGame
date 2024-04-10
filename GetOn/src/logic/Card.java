package logic;

public class Card {	
	
	private String type; 				// type of the card e.g. BULLY
	private String value; 				// value of the card e.g. TAVERN
	protected String [] pos_values; 	// array of possible values for each type
	protected int [] amount; 			// array of amounts of each card for stack generation
	
	// Constructor
	public Card (String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	// Getting the type of the card
	public String getType() {
		return this.type;
	}
	
	// Getting the value of the card
	public String getValue() {
		return this.value;
	}
	
	// Adjust default toString function
	public String toString() {
		return this.type + "_" + this.value;
	}
	
	// Getting the representation of the card by combining the type and value
	public String getCardName() {
		return toString();
	}
	
	// Method to retrieve possible values for the specific type
	public String[] getPossibleValues() {        
        return this.pos_values;
	}
	
	// Method to get amounts of the specific card
	public int[] getAmounts() {
		return this.amount;
	}
	
	// Method to check if value is in pos_values for deck building
	protected void validateValue(String value) {
		for (String validValue : pos_values) {
			if (validValue.equals(value)) {
				return;
			}
		}
		throw new IllegalArgumentException("Entered value is not in possible values list");
	}
	
	// Method to check if the card is playable, specified subclasses
	public boolean isPlayable() {
		return false;
	}
	
	public void playCard(Player currentPlayer, Stack discard) {
	}
}
