package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;

public class BullyCardTest extends TestCase {


	// Test bully card creation
	public void testCreationOfbullyCard() {
		// Creating a bully card
		BullyCard bullyCard = new BullyCard("HOSTEL");

		assertNotNull(bullyCard);
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

		// Creating a bully  card
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

}
