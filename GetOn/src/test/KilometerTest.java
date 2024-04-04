package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.KilometerCard;

public class KilometerTest extends TestCase {

	// Test km card creation
	public void testCreationOfKmCard() {
		// Creating a km card
		KilometerCard kmCard = new KilometerCard("FIVE");

		assertNotNull(kmCard);
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "KILOMETER";

		// Creating a km card
		KilometerCard kmCard = new KilometerCard("FIVE");

		// Getting the type
		String test = kmCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "FIVE";

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(target);

		// Getting the type
		String test = kmCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = "FIVE";
		String target1 = "KILOMETER_" + target;

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(target);


		// Testing getCardNameMethod
		String test = kmCard.getCardName();

		assertEquals(target1, test);
	}
	
	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard("FIVE");
		
		// Testing getCardNameMethod
		String test = Arrays.toString(kmCard.getPossibleValues());
		
		assertEquals("[FIVE, SIX, EIGHT, TEN]", test);		
	}

}
