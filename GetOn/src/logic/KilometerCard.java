package logic;

import utilities.Constant;

/**
 * Kilometer Card class inherits from Card class. This class handles the
 * requirements to play the Kilometer Cards and consequences for the Kilometer
 * Cards.
 */
public class KilometerCard extends Card {

	/**
	 * Constructor for Kilometer Card, assign possible values and number of cards
	 * 
	 * @param value
	 */
	public KilometerCard(String value) {
		super("KILOMETER", value);

		// Assign possible km values
		this.pos_values = Constant.VALID_KM_VALUES;
		validateValue(value);

		// Assign amount per card
		this.amount = Constant.VALID_KM_AMOUNTS;
	}

	/**
	 * Method to get the requirements to play a Kilometer Card.
	 * 
	 * @return requirements - The requirements to play a Kilometer Card.
	 */
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type (-1 - ignore)
		// Maximum number of the same cards played (-1 for no limit)
		String value = this.getValue();

		// To play 5 km: (to be on bike, not bullied and 8 cards max)
		if (value.equals(Constant.FIVE)) {
			String[] requirements = { Constant.TRUE, Constant.FALSE, Constant.IGNORE, Constant.IGNORE, "7" };
			return requirements;
		}
		// To play 6 km: (to be on bike, not bullied and 4 cards max)
		else if (value.equals(Constant.SIX)) {
			String[] requirements = { Constant.TRUE, Constant.FALSE, Constant.IGNORE, Constant.IGNORE, "3" };
			return requirements;
		}
		// To play 8 or 10 km: (to be on bike, not bullied, to have wind and 2 cards
		// max)
		else {
			String[] requirements = { Constant.TRUE, Constant.FALSE, Constant.TRUE, Constant.IGNORE, "1" };
			return requirements;
		}
	}

	// Implement method for getConsequences
	/**
	 * Method to get the Consequences after playing the Kilometer Card
	 * 
	 * @return consequences - The Consequences of the Kilometer Card
	 */
	public String[] getConsequences() {
		// Changes for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type
		// Kilometer increase
		String[] consequences = { Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, this.getValue() };
		return consequences;
	}
}
