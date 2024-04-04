package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.RepairCard;

public class RepairCardTest extends TestCase {
	// Test repair card creation
	public void testCreationOfrepairCard() {
		// Creating a repair card
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		assertNotNull(repairCard);
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "REPAIR";

		// Creating a repair card
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		// Getting the type
		String test = repairCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "BIKE_REPAIR";

		// Creating a repair card
		RepairCard repairCard = new RepairCard(target);

		// Getting the type
		String test = repairCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = "BIKE_REPAIR";
		String target1 = "REPAIR_" + target;

		// Creating a repair card
		RepairCard repairCard = new RepairCard(target);

		// Testing getCardNameMethod
		String test = repairCard.getCardName();

		assertEquals(target1, test);
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		// Testing getCardNameMethod
		String test = Arrays.toString(repairCard.getPossibleValues());
		System.out.print(Arrays.toString(repairCard.getPossibleValues()));

		assertEquals("[BIKE_REPAIR, BARRIER_OPEN]", test);
	}

}
