package logic;

public class Card {	
	
	private String type;
	private String value;
	
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
	
}
