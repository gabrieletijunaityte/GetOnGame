package logic;

public class StatusCard extends Card {

	// Constructor
	public StatusCard(String value) {
		super("STATUS", value);

		// Assign possible status values
		this.pos_values = new String[] { "GET_ON", "TAIL_WIND" };
		validateValue(value);
	}
}
