package logic;

public class RepairCard extends Card {

	// Constructor
	public RepairCard(String value) {
		super("REPAIR", value);

		// Assign possible repair values
		this.setPos_values(new String[] { "BIKE_REPAIR", "BARRIER_OPEN" });
		validateValue(value);

		// Assign amount per card
		this.setAmount(new int[] { 8, 8 });
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
	
	// Implement method for getConsequences
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
