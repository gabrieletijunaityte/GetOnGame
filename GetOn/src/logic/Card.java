package logic;

public class Card {
	// Card attributes
	private final Type type;
	private final Value value;
	
	// Constructor
	public Card(Type type, Value value) {
		this.type = type;
		this.value = value;
	}
	
	// Getting the type of the card
	public Type getType() {
		return this.type;
	}
	
	// Getting the value of the card
	public Value getValue() {
		return this.value;
	}
	
	// Adjust default toString function
	public String toString() {
		return type + "_" + value;
	}
	
	// getting the representation of the card by combining the type and value
	public String getCardName() {
		return toString();
	}

}
