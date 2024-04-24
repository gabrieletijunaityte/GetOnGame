package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.Card;
import logic.StatusCard;
import utilities.Constant;

public class StatusCardTest extends TestCase {

	// Test status card creation
	public void testCreationOfstatusCard() {
		// Creating a status card
		StatusCard statusCard = new StatusCard(Constant.GET_ON);

		assertNotNull(statusCard);
	}

	// Test status card creation with invalid value
	public void testBadCreationOfStatusCard() {

		try {
			// Creating a repair card
			StatusCard statusCard = new StatusCard("BAD_VALUE");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = Constant.STATUS;

		// Creating a status card
		StatusCard statusCard = new StatusCard(Constant.GET_ON);

		// Getting the type
		String test = statusCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = Constant.GET_ON;

		// Creating a status card
		StatusCard statusCard = new StatusCard(target);

		// Getting the type
		String test = statusCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = Constant.GET_ON;
		String target1 = Constant.STATUS + "_" + target;

		// Creating a status card
		StatusCard statusCard = new StatusCard(target);

		// Testing getCardNameMethod
		String test = statusCard.getCardName();

		assertEquals(target1, test);
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		StatusCard statusCard = new StatusCard(Constant.GET_ON);

		// Testing getCardNameMethod
		String test = Arrays.toString(statusCard.getPossibleValues());
		String target = Arrays.toString(Constant.VALID_STATUS_VALUES);

		assertEquals(target, test);
	}

	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		StatusCard card = new StatusCard(Constant.GET_ON);

		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());
		String target = Arrays.toString(Constant.VALID_STATUS_AMOUNTS);

		assertEquals(target, test);
	}

	// Test getRequirements
	public void testGetRequirements() {
		// Creating a statusCard
		Card statusCard = new StatusCard(Constant.TAIL_WIND);
		String[] target = { Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = statusCard.getRequirements();

		assertTrue(Arrays.equals(target, test));
	}

	// Test getConsequences for GET_ON
	public void testGetConsequencesCaseA() {
		// Creating a statusCard
		Card statusCard = new StatusCard(Constant.GET_ON);
		String[] target = { Constant.TRUE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = statusCard.getConsequences();

		assertTrue(Arrays.equals(target, test));
	}

	// Test getConsequences for TAIL_WIND
	public void testGetConsequencesCaseB() {
		// Creating a statusCard
		Card statusCard = new StatusCard(Constant.TAIL_WIND);
		String[] target = { Constant.IGNORE, Constant.IGNORE, Constant.TRUE, Constant.IGNORE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = statusCard.getConsequences();

		assertTrue(Arrays.equals(target, test));
	}
}
