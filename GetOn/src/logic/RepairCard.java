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
		super(Constant.REPAIR, value, Constant.VALID_REPAIR_VALUES, Constant.VALID_REPAIR_AMOUNTS);
		
		// Validate the entered value);
		validateValue(value);
	}

	/**
	 * This method provides an array of strings indicating whether certain conditions required
	 * to play the card are met.
	 * 
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
		String [] requirements ;
		
		// To play BIKE_REPAIR: be bullied with FLAT_TIRE
		if (value.equals(Constant.BIKE_REPAIR)) {
			requirements = new String []{Constant.IGNORE,Constant.TRUE, Constant.IGNORE,Constant.FLAT_TIRE,Constant.IGNORE};
			
		}
		// To play BARRIER_OPEN: be bullied with CRISS_CROSS
		else {
			requirements = new String [] {Constant.IGNORE,Constant.TRUE, Constant.IGNORE, Constant.CRISS_CROSS,Constant.IGNORE};
		}
		return requirements;
	}

	/**
	 * This method returns an array of strings that detail the effects of playing
	 * the repair card.
	 * 
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