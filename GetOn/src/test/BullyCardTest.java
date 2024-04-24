package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;
import utilities.Constant;

public class BullyCardTest extends TestCase {

	// Test bully card creation
	public void testCreationOfbullyCard() {
		// Creating a bully card
		BullyCard bullyCard = new BullyCard(Constant.TAVERN);
		
		assertNotNull(bullyCard);
	}

	// Test bully card creation with invalid value
	public void testBadCreationOfbullyCard() {
		try {
			// Creating a bully card
			BullyCard bullyCard = new BullyCard("BAD_VALUE");
		} catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = Constant.BULLY;

		// Creating a bully card
		BullyCard bullyCard = new BullyCard(Constant.TAVERN);

		// Getting the type
		String test = bullyCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = Constant.TAVERN;

		// Creating a bully card
		BullyCard bullyCard = new BullyCard(target);

		// Getting the type
		String test = bullyCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = Constant.TAVERN;
		String target1 = Constant.BULLY + "_" + target;

		// Creating a bully card
		BullyCard bullyCard = new BullyCard(target);

		// Testing getCardNameMethod
		String test = bullyCard.getCardName();

		assertEquals(target1, test);
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		BullyCard bullyCard = new BullyCard(Constant.TAVERN);

		// Testing getCardNameMethod
		String test = Arrays.toString(bullyCard.getPossibleValues());
		String target = Arrays.toString(new String [] {Constant.TAVERN, Constant.CROSSWIND, Constant.FLAT_TIRE, Constant.CRISS_CROSS});

		assertEquals(target, test);
	}

	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		BullyCard card = new BullyCard(Constant.TAVERN);

		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());
		String target = Arrays.toString(Constant.VALID_BULLY_AMOUNTS);
		

		assertEquals(target, test);
	}

	// Test getRequirements
	public void testGetRequirements() {
		// Creating a bullyCard
		BullyCard bullyCard = new BullyCard(Constant.TAVERN);
		String[] target = { Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = bullyCard.getRequirements();

		assertTrue(Arrays.equals(target, test));
	}

	// Test getConsequences
	public void testGetConsequencesCaseA() {
		// Creating a bullyCard
		BullyCard bullyCard = new BullyCard(Constant.TAVERN);
		String[] target = { Constant.FALSE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = bullyCard.getConsequences();

		assertTrue(Arrays.equals(target, test));

	}

	// Test getConsequences for CrossWind
	public void testGetConsequencesCaseB() {
		// Creating a bullyCard
		BullyCard bullyCard = new BullyCard(Constant.CROSSWIND);
		String[] target = { Constant.IGNORE, Constant.IGNORE, Constant.FALSE, Constant.IGNORE, Constant.IGNORE };

		// Testing getPossibleValues() method
		String[] test = bullyCard.getConsequences();

		assertTrue(Arrays.equals(target, test));
	}
}
