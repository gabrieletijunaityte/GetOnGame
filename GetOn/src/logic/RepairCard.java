package logic;

import utilities.Constant;

/**
 * RepairCard class. It is a card element of the game,
 * used to repair the status of the player. The specific requirements
 * of each repair card type have to be met before they can be played.
 */
public class RepairCard extends Card {

	/**
	 * This constructor method initializes a repair card and checks if the value is valid.
	 * It assigns the repair values to the cards, and the number of cards of that type.
	 * 
	 * @param value The value assigned to the repair card.
	 */
	public RepairCard(String value) {
		super(Constant.REPAIR, value);

		// Assign possible repair values
		this.pos_values = Constant.VALID_REPAIR_VALUES;
		validateValue(value);

		// Assign amount per card
		this.amount = Constant.VALID_REPAIR_AMOUNTS;
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
		if (value.equals(Constant.BIKE_REPAIR)) {
			String [] requirements = {Constant.IGNORE,Constant.TRUE, Constant.IGNORE,Constant.FLAT_TIRE,Constant.IGNORE};
			return requirements;
		}
		// To play BARRIER_OPEN: be bullied with CRISS_CROSS
		else {
			String [] requirements = {Constant.IGNORE,Constant.TRUE, Constant.IGNORE, Constant.CRISS_CROSS,Constant.IGNORE};
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

		String[] consequences = {Constant.IGNORE, Constant.FALSE, Constant.IGNORE, null, Constant.IGNORE};
		return consequences;
	}
}