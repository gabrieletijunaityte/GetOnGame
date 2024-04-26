package logic;

/**
 * Card class is the Super Class used for Inheritance by BullyCard,
 * KilometerCard, RepairCard, StatusCard subclasses. It handles the creation of
 * the cards, validation.
 */
public class Card {

	private String type; // type of the card e.g. BULLY
	private String value; // value of the card e.g. TAVERN
	private String[] pos_values; // array of possible values for each type
	private int[] amount; // array of amounts of each card for stack generation

	/**
	 * This is the Constructor for Card class.
	 * 
	 * @param type  String
	 * @param value String
	 */
	public Card(String type, String value, String [] pos_values, int[] amount) {
		this.type = type;
		this.value = value;
		this.pos_values = pos_values;
		this.amount = amount;
	}

	/**
	 * Method to get the type of the card.
	 * 
	 * @return type of the card.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Method to get the value of the card.
	 * 
	 * @return value of the card.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Method to return the card as a String return
	 * 
	 * @return The type_value of the card.
	 */
	public String toString() {
		return this.type + "_" + this.value;
	}

	/**
	 * Method to get the name of the card by combining type and value.
	 * 
	 * @return name of the card.
	 */
	public String getCardName() {
		return toString();
	}

	/**
	 * Method to retrieve possible values for the specific type
	 * 
	 * @return Array of String with the possible values.
	 */
	public String[] getPossibleValues() {
		return this.pos_values;
	}

	/**
	 * Method to get amounts of the specific card
	 * 
	 * @return The number of the specific card
	 */
	public int[] getAmounts() {
		return this.amount;
	}

	/**
	 * Method to check if value is in pos_values for deck building
	 * 
	 * @param value
	 */
	public void validateValue(String value) {
		for (String validValue : getPossibleValues()) {
			if (validValue.equals(value)) {
				return;
			}
		}
		throw new IllegalArgumentException("Entered value is not in possible values list");
	}

	/**
	 * Method to get the requirements of the card.
	 * 
	 * @return The requirements of the card.
	 */
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type
		// Maximum number of the same cards played
		String[] requirements = {};
		return requirements;
	}

	/**
	 * Method to set the consequences of the card.
	 * 
	 * @return The consequences of the card.
	 */
	public String[] getConsequences() {
		// Changes for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type
		// Kilometer increase
		String[] consequences = {};
		return consequences;
	}
}
