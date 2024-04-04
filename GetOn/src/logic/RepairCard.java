package logic;

public class RepairCard extends Card {

	// Constructor
	public RepairCard(String value) {
		super("REPAIR", value);

		// Assign possible repair values
		this.pos_values = new String[] { "BIKE_REPAIR", "BARRIER_OPEN" };
	}
}
