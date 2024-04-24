package logic;

/**
 * Represents a repair card, extending the generic card class.
 * <p>
 * RepairCard is used to repair the status of the player. The specific requirements
 * of each repair card type have to be met before they can be played.
 * </p>
 */
public class RepairCard extends Card {

	/**
	 * Constructs a new RepairCard with a specified repair value.
	 * <p>
	 * This constructor initializes a repair card and checks if the value is valid.
	 * It assigns the repair values to the cards, and the number of cards of that type.
	 * </p>
	 * @param value The value assigned to the repair card.
	 */
	public RepairCard(String value) {
		super("REPAIR", value);

		// Assign possible repair values
		this.pos_values = new String[] { "BIKE_REPAIR", "BARRIER_OPEN" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 8, 8 };
	}

	/**
	 * Retrieves the requirements necessary to play the repair card.
	 * <p>
	 * This method provides an array of strings indicating whether certain conditions required
	 * to play the card are met.
	 * </p>
	 * @return An array of strings representing the requirements to play this card.
	 */
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
			// GetOnStatus
			// BulliedStatus
			// hasWindStatus
			// Bullied type (-1 - ignore)
			// Maximum number of the same cards played (-1 for no limit)
		String value = this.getValue();
		
		// To play BIKE_REPAIR: be bullied with FLAT_TIRE
		if (value.equals("BIKE_REPAIR")) {
			String [] requirements = {"-1", "true", "-1", "FLAT_TIRE", "-1"};
			return requirements;
		}
		// To play BARRIER_OPEN: be bullied with CRISS_CROSS
		else {
			String [] requirements = {"-1", "true", "-1", "CRISS_CROSS", "-1"};
			return requirements;
		}
	}

	/**
	 * Computes the consequences of playing this specific type of repair card.
	 * <p>
	 * This method returns an array of strings that detail the effects of playing
	 * the repair card.
	 * </p>
	 * @return An array of strings with detailing the consequences of the played card.
	 */
	public String[] getConsequences() {
		// Changes for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type
		// Kilometer increase

		String[] consequences = { "-1", "false", "-1", null, "-1" };
		return consequences;
	}
}