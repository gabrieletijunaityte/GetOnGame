package logic;

import utilities.Constant;

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
		super(Constant.BULLY, value, Constant.VALID_BULLY_VALUES, Constant.VALID_BULLY_AMOUNTS);

		// Validate the entered value
		validateValue(value);
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
		String[] requirements = { Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE };
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
		String[] consequences;

		if (this.getValue().equals("CROSSWIND")) {
			consequences = new String[] { Constant.IGNORE, Constant.IGNORE, Constant.FALSE, Constant.IGNORE,
					Constant.IGNORE };

		} else if (this.getValue().equals(Constant.TAVERN)) {
			consequences = new String[] { Constant.FALSE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE,
					Constant.IGNORE };
		} else {
			consequences = new String[] { Constant.FALSE, Constant.TRUE, Constant.IGNORE, this.getValue(),
					Constant.IGNORE };
		}
		return consequences;
	}
}
