package logic;

public class StatusCard extends Card {

	// Constructor
	public StatusCard(String value) {
		super("STATUS", value);

		// Assign possible status values
		this.setPos_values(new String[] { "GET_ON", "TAIL_WIND" });
		validateValue(value);

		// Assign amount per card
		this.setAmount(new int[] { 14, 5 });
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
		if (value.equals("GET_ON")) {
			String [] requirements = {"-1", "false", "-1", "-1", "-1"};
			return requirements;
		}
		// To play TAIL_WIND - always possible
		else {
			String [] requirements = {"-1", "-1", "-1", "-1", "-1"};
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

		if (this.getValue().equals("GET_ON")) {

			String[] consequences = { "true", "-1", "-1", "-1", "-1" };

			return consequences;
		} else {

			String[] consequences = { "-1", "-1", "true", "-1", "-1" };
			return consequences;

		}

	}
}