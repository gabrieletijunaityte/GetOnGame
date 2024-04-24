package logic;

/**
 * BullyCard class inherits from the Card class The class handles the
 * requirements for the bully card to play and the consequences of the
 * bullycards
 */
public class BullyCard extends Card {

	/**
	 * Constructor of the BullyCard Assign possible bully values
	 * 
	 * @param value
	 */
	public BullyCard(String value) {
		super("BULLY", value);

		// Assign possible Bully values
		this.pos_values = new String[] { "TAVERN", "CROSSWIND", "FLAT_TIRE", "CRISS_CROSS" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 2, 4, 3, 3 };
	}

	/**
	 * Method to get the requirements to play a bully card
	 * 
	 * @return requirements - the requirements to play a bully card
	 */
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Maximum number of the same cards played
		// Bullied type
		// None of the statuses must be active to play a bully card
		String[] requirements = { "-1", "-1", "-1", "-1", "-1" };
		return requirements;
	}

	/**
	 * Method to get the consequences of a bully card
	 * 
	 * @return consequences - consequences of each of the bully cards.
	 */
	public String[] getConsequences() {
		// Changes for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type
		// Kilometer increase
		// Adjust the consequences when a bully card is played
		if (this.getValue().equals("CROSSWIND")) {
			String[] consequences = { "-1", "-1", "false", "-1", "-1" };
			return consequences;
		} else if (this.getValue().equals("TAVERN")) {
			String[] consequences = { "false", "-1", "-1", "-1", "-1" };
			return consequences;
		} else {
			String[] consequences = { "false", "true", "-1", this.getValue(), "-1" };
			return consequences;
		}
	}
}
