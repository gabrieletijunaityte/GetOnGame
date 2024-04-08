package logic;

public class Card {	
	
	private String type;
	private String value;
	protected String [] pos_values;
	protected int [] amount;
	
	// Constructor
	public Card (String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	// getting the type of the card
	public String getType() {
		return this.type;
	}
	
	// getting the value of the card
	public String getValue() {
		return this.value;
	}
	
	// Adjust default toString function
	public String toString() {
		return this.type + "_" + this.value;
	}
	
	// getting the representation of the card by combining the type and value
	public String getCardName() {
		return toString();
	}
	
	// Method to retrieve possible values
	public String[] getPossibleValues() {        
        return this.pos_values;
	}
	
	public int[] getAmounts() {
		return this.amount;
	}
	
	// Method to check if value is in pos_values
	protected void validateValue(String value) {
		for (String validValue : pos_values) {
			if (validValue.equals(value)) {
				return;
			}
		}
		throw new IllegalArgumentException("Entered value is not in possible values list");
	}
	public boolean isPlayable() {
		return false;
	}
	
}
