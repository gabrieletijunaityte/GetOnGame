package logic;

import utilities.Constant;

public class StatusCard extends Card {

	// Constructor
	public StatusCard(String value) {
		super("STATUS", value);

		// Assign possible status values
		this.pos_values = Constant.VALID_STATUS_VALUES;
		validateValue(value);

		// Assign amount per card
		this.amount = Constant.VALID_STATUS_AMOUNTS;
	}

	// getRequirements method
	public String[] getRequirements() {
		// Requirements for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type (-1 - ignore)
		// Maximum number of the same cards played (-1 for no limit)
		String value = this.getValue();

		// To play GET_ON: be not bullied
		if (value.equals(Constant.GET_ON)) {
			String[] requirements = { Constant.IGNORE, Constant.FALSE, Constant.IGNORE, Constant.IGNORE,
					Constant.IGNORE };
			return requirements;
		}
		// To play TAIL_WIND - always possible
		else {
			String[] requirements = { Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE,
					Constant.IGNORE };
			return requirements;
		}
	}

	// Implement method for getConsequences
	public String[] getConsequences() {
		// Changes for (-1 to ignore)
		// GetOnStatus
		// BulliedStatus
		// hasWindStatus
		// Bullied type
		// Kilometer increase

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