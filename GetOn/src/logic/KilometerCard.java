package logic;

public class KilometerCard extends Card {

	// Constructor
	public KilometerCard(String value) {
		super("KILOMETER", value);

		// Assign possible km values
		this.pos_values = new String[] { "FIVE", "SIX", "EIGHT", "TEN" };
		validateValue(value);

		// Assign amount per card
		this.amount = new int[] { 24, 12, 8, 8 };
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
		
		// To play 5 km: (to be on bike, not bullied and 8 cards max)
		if (value.equals("FIVE")) {
			String [] requirements = {"true", "false", "-1", "-1", "8"};
			return requirements;
		}
		// To play 6 km: (to be on bike, not bullied and 4 cards max)
		else if (value.equals("SIX")) {
			String [] requirements = {"true", "false", "-1", "-1", "4"};
			return requirements;
		}
		// To play 8 or 10 km: (to be on bike, not bullied, to have wind and 2 cards max)
		else {
			String [] requirements = {"true", "false", "true", "-1", "2"};
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

		String[] consequences = { "-1", "-1", "-1", "-1", this.getValue() };
		return consequences;


	}
}
