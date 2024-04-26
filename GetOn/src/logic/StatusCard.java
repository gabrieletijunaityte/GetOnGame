package logic;

import utilities.Constant;

/**
 * Represents a two types of status cards in the game that affect the status of
 * the player that it was played on.
 */
public class StatusCard extends Card {

	/**
	 * Creates a new StatusCard with a specified value. Cards, when played, result
	 * in consequences for the player that it was played on.
	 * 
	 * @param value The value representing the type of status card.
	 */
	public StatusCard(String value) {
		super("STATUS", value, Constant.VALID_STATUS_VALUES, Constant.VALID_STATUS_AMOUNTS);
		
		// Validate the entered value);
		validateValue(value);
	}

	/**
	 * Gets the playing requirements for this status card based on the card's value.
	 * 
	 * @return an array of strings representing the requirements (ignored of value
	 *         == -1: - Index 0: getOnStatus - Index 1: bulliedStatus - Index 2:
	 *         hasWindStatus - Index 3: bullied type - Index 4: maximum number of
	 *         the same cards played
	 */
	public String[] getRequirements() {
		String value = this.getValue();

		// Condition to play GET_ON: be not bullied
		if (value.equals(Constant.GET_ON)) {
			String[] requirements = { Constant.IGNORE, Constant.FALSE, Constant.IGNORE, Constant.IGNORE,
					Constant.IGNORE };
			return requirements;
		}
		// Condition to play TAIL_WIND: always possible
		else {
			String[] requirements = { Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE,
					Constant.IGNORE };
			return requirements;
		}
	}

	/**
	 * Gets the consequences of playing the card. These changes are applied to the
	 * game state when the card is used (ignored if value == -1).
	 * 
	 * @return an array of strings representing the consequences (ignored of value
	 *         == -1: - Index 0: change to getOnStatus - Index 1: change to
	 *         bulliedStatus - Index 2: change to hasWindStatus - Index 3: change to
	 *         bullied type - Index 4: kilometer increase
	 */
	public String[] getConsequences() {
		if (this.getValue().equals(Constant.GET_ON)) {
			String[] consequences = { Constant.TRUE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE,
					Constant.IGNORE };
			return consequences;
		} else {
			String[] consequences = { Constant.IGNORE, Constant.IGNORE, Constant.TRUE, Constant.IGNORE,
					Constant.IGNORE };
			return consequences;
		}
	}
}