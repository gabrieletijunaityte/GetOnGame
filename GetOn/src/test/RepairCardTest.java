package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.RepairCard;
import utilities.Constant;
import logic.Card;

public class RepairCardTest extends TestCase {
	// Test repair card creation
	public void testCreationOfRepairCard() {
		// Creating a repair card
		RepairCard repairCard = new RepairCard(Constant.BIKE_REPAIR);

		assertNotNull(repairCard);
	}

	// Test repair card creation with invalid value
	public void testBadCreationOfRepairCard() {

		try {
			// Creating a repair card
			RepairCard repairCard = new RepairCard("BAD_VALUE");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testGetType() {
		// Setting the target
		String target = Constant.REPAIR;

		// Creating a repair card
		RepairCard repairCard = new RepairCard(Constant.BIKE_REPAIR);

		// Getting the type
		String test = repairCard.getType();

		// Asserting if it is right type
		assertTrue(target.equals(test));
	}

	// Test the value retrieval method
	public void testGetValue() {
		// Setting the target
		String target = Constant.BIKE_REPAIR;

		// Creating a repair card
		RepairCard repairCard = new RepairCard(target);

		// Getting the type
		String test = repairCard.getValue();

		// Asserting if it is right type
		assertTrue(target.equals(test));
	}

// Test the getCardName() method
	public void testGetCardName() {
		// Setting the target
		String target = Constant.BIKE_REPAIR;
		String target1 = Constant.REPAIR + "_" + target;

		// Creating a repair card
		RepairCard repairCard = new RepairCard(target);

		// Testing getCardNameMethod
		String test = repairCard.getCardName();

		assertTrue(target1.equals(test));
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		RepairCard repairCard = new RepairCard(Constant.BIKE_REPAIR);

		// Testing getCardNameMethod
		String test = Arrays.toString(repairCard.getPossibleValues());
		String target = Arrays.toString(Constant.VALID_REPAIR_VALUES);
		
		assertTrue(target.equals(test));
	}

	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		RepairCard card = new RepairCard(Constant.BIKE_REPAIR);

		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());
		String target = Arrays.toString(Constant.VALID_REPAIR_AMOUNTS);

		assertTrue(target.equals(test));
	}

	// Test getRequirements
	public void testGetRequirements() {
		// Creating a statusCard
		Card repairCard = new RepairCard(Constant.BIKE_REPAIR);
		String[] target = { Constant.IGNORE, Constant.TRUE, Constant.IGNORE, Constant.FLAT_TIRE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = repairCard.getRequirements();

		assertTrue(Arrays.equals(target, test));
	}

	// Test getConsequences
	public void testGetConsequences() {
		// Creating a statusCard
		Card repairCard = new RepairCard(Constant.BIKE_REPAIR);
		String[] target = { Constant.IGNORE, Constant.FALSE, Constant.IGNORE, null, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = repairCard.getConsequences();

		assertTrue(Arrays.equals(target, test));
	}
}