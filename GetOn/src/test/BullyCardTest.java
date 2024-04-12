package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;
import logic.Card;
import logic.KilometerCard;
import logic.Player;
import logic.Stack;

public class BullyCardTest extends TestCase {

	// Test bully card creation
	public void testCreationOfbullyCard() {
		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");

		assertNotNull(bullyCard);
	}

	// Test bully card creation with invalid value
	public void testBadCreationOfbullyCard() {

		try {
			// Creating a bully card
			BullyCard bullyCard = new BullyCard("BAD_VALUE");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "BULLY";

		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");

		// Getting the type
		String test = bullyCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "TAVERN";

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
		String target = "TAVERN";
		String target1 = "BULLY_" + target;

		// Creating a bully card
		BullyCard bullyCard = new BullyCard(target);

		// Testing getCardNameMethod
		String test = bullyCard.getCardName();

		assertEquals(target1, test);
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		BullyCard bullyCard = new BullyCard("TAVERN");

		// Testing getCardNameMethod
		String test = Arrays.toString(bullyCard.getPossibleValues());
		System.out.print(Arrays.toString(bullyCard.getPossibleValues()));

		assertEquals("[TAVERN, CROSSWIND, FLAT_TIRE, CRISS_CROSS]", test);
	}

	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		BullyCard card = new BullyCard("TAVERN");

		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());

		assertEquals("[2, 4, 3, 3]", test);
	}

	// Test playing bully card
	public void testPlayCard() {
		// creating dummy players
		Player bulliedPlayer = new Player("Gabby", false);

		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");

		// Create discard pile
		Stack discard = new Stack();

		// Test playing bully card to Gabby
		bullyCard.playCard(bulliedPlayer, discard);

		boolean target = true;
		boolean test = bulliedPlayer.getBulliedStatus();

		boolean target2 = false;
		boolean test2 = bulliedPlayer.getOnBikeStatus();

		// Check bully status
		assertEquals(target, test);
		assertEquals("TAVERN", bulliedPlayer.getBulliedType());

		// Check onbike status
		assertEquals(target2, test2);
	}

	// Test getRequirements
	public void testGetRequirements() {
		// Creating a bullyCard
		BullyCard bullyCard = new BullyCard("TAVERN");
		String[] target = { "-1", "-1", "-1", "-1", "-1" };

		// Testing getPossibleValues() method
		String[] test = bullyCard.getRequirements();

		assertTrue(Arrays.equals(target, test));
	}
	
	// Test getConsequences
	public void testGetConsequencesCaseA() {

		// Creating a bullyCard
		BullyCard bullyCard = new BullyCard("TAVERN");
		String[] target = { "false", "true", "-1", "TAVERN", "-1" };

		// Testing getPossibleValues() method
		String[] test = bullyCard.getConsequences();

		assertTrue(Arrays.equals(target, test));

	}
	
	// Test getConsequences for CrossWind
	public void testGetConsequencesCaseB() {

		// Creating a bullyCard
		BullyCard bullyCard = new BullyCard("CROSSWIND");
		String[] target = { "-1", "-1", "false", "-1", "-1" };

		// Testing getPossibleValues() method
		String[] test = bullyCard.getConsequences();

		assertTrue(Arrays.equals(target, test));

	}

}
